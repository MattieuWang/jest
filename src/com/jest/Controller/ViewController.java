package com.jest.Controller;
import com.jest.models.CardModel;
import com.jest.views.BackgroundView;
import com.jest.views.FinDeJeuView;
import com.jest.views.StartRequireView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ViewController {
    private JFrame frame;
//    private ViewManager views;
    private JLayeredPane layeredPane;
    private BackgroundView bgView;
    private LinkedList<CardModel> cdModels;
    private StartRequireView startRequireView;
    private FinDeJeuView finDeJeuView;
    private JButton btn_start;
    private CardModel cardRef;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private static ViewController viewController = null;

    private ViewController()
    {
//        views = new ViewManager();
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initViews();
        frame.setContentPane(layeredPane);
        frame.setVisible(true);
    }

    public static ViewController getInstance()
    {
        if (viewController == null)
        {
            viewController = new ViewController();
        }
        return viewController;
    }

    public void initViews()
    {
        cdModels = new LinkedList<>();
        layeredPane = new JLayeredPane();
        bgView = new BackgroundView(WIDTH,HEIGHT);
        startRequireView = new StartRequireView();
        finDeJeuView = new FinDeJeuView();

        //
        initStartRequireView();
        //
        //
        //
        initFinDeJeuView();

    }

    public void initTous()
    {
        startRequireView.setNbJoueurs(0);
        finDeJeuView.initData();
        finDeJeuView.initNext();
    }


    private void initStartRequireView()
    {
        layeredPane.add(bgView,0,0);
        cardRef = new CardModel((new ImageIcon("src/images/cardRef.jpg")).getImage());
//        cardRef.setBounds(WIDTH/2 - cardRef.getW()/2,HEIGHT/2 - cardRef.getH()/2,cardRef.getW(),cardRef.getH());
        cardRef.setPosition(0,0);
        cardRef.setVisible(false);
        layeredPane.add(cardRef,1,5);


        btn_start = new JButton("start");
        btn_start.setVisible(false);
        btn_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layeredPane.getComponent(layeredPane.getIndexOf(startRequireView.getPanel())).setVisible(true);
                layeredPane.getComponent(layeredPane.getIndexOf(btn_start)).setVisible(false);
            }
        });
        btn_start.setBounds(550,300,100,50);
        layeredPane.add(btn_start,1,1);

        layeredPane.add(startRequireView.getPanel(),1,2);
    }


    public void doStartRequire()
    {
        btn_start.setVisible(true);
    }
    public void finishStartRequire()
    {
        cardRef.setPosition(100,400);
        cardRef.setVisible(true);
    }

    private void initFinDeJeuView()
    {
        layeredPane.add(finDeJeuView.getPanel(),10,10);     // le niveau doit etre change apres.
    }

    public void doFinDeJeu(Object [][] resultat)
    {
        for (int i=0;i<resultat.length;i++)
        {
            finDeJeuView.addData((String)resultat[i][0],(Integer)resultat[i][1]);
        }
        finDeJeuView.getPanel().setVisible(true);

        Thread thread = new Thread();
        while (!finDeJeuView.isNext())
        {
            try {
//                System.out.println("wait");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        initTous();
    }


    public int getNbJoueurs()
    {
        return startRequireView.getNbJoueurs();
    }


    public JFrame getFrame() {
        return frame;
    }
}
