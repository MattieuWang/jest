package com.jest.Controller;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.models.CardModel;
import com.jest.models.JoueurBref;
import com.jest.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class ViewController {
    private JFrame frame;
//    private ViewManager views;
    private static JLayeredPane layeredPane;
    private BackgroundView bgView;
    private LinkedList<CardModel> cdModels;
    private StartRequireView startRequireView;
    private ChoixView choixView;
    private static MakeOfferView makeOfferView;
    private FinDeJeuView finDeJeuView;
    private static TakeCardView takeCardView;
    private JButton btn_start;
    private CardModel cardRef;
    public static final int WIDTH = 1400;
    public static final int HEIGHT = 800;
    private static int ref_x;
    private static int ref_y;
    private static int ref_h;
    private static int ref_w;
    private static boolean[] hasChosen = {false,false,false,false};
    private static int[] choixCarte = {0,0,0,0};
    private static int[] choixCarteNb = {0,0,0,0};
    private static Object[][] joueurCarte;

    private static ViewController viewController = null;

    private ViewController()
    {
//        views = new ViewManager();
        joueurCarte = new Object[4][2];
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initViews();
        frame.setContentPane(layeredPane);
        frame.setVisible(true);
//        initCartes();
    }
    public void initCartes(LinkedList<Carte> cartes)
    {
        LinkedList<CardModel> cardModels = new LinkedList<>();
        for (Carte carte : cartes)
        {
            cardModels.add(new CardModel((new ImageIcon(carte.getImageLocation())).getImage(),carte));
        }
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
        choixView = new ChoixView();
        makeOfferView = new MakeOfferView();
        takeCardView = new TakeCardView();
        //
        initStartRequireView();
        initChoixView();
        initMakeOfferView();
        initTakeCardView();
        initFinDeJeuView();

    }

    public void initTous()
    {
        layeredPane.removeAll();
        choixView = new ChoixView();

        startRequireView.setNbJoueurs(0);
        initStartRequireView();
//        choixView.initView();
        initChoixView();
        finDeJeuView = new FinDeJeuView();
        finDeJeuView.initData();
        finDeJeuView.initNext();
        cardRef.setVisible(false);
        initTakeCardView();
        initMakeOfferView();
    }


    private void initStartRequireView()
    {
        layeredPane.add(bgView,0,0);
        cardRef = new CardModel((new ImageIcon("src/images/cardRef.png")).getImage());
        cardRef.setPosition(0,0);
        cardRef.setVisible(false);
        layeredPane.add(cardRef,5,5);
        cardRef.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cardRef.setBounds(cardRef.getX(),cardRef.getY()-10,cardRef.getW(),cardRef.getH());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardRef.setBounds(cardRef.getX(),cardRef.getY()+10,cardRef.getW(),cardRef.getH());
            }
        });

//        JPanel test = new JPanel();
//        test.setBounds(100,100,200,200);
//        test.setBackground(Color.ORANGE);
//        test.setOpaque(false);
//        JButton testbtn = new JButton("aaa");
//        test.add(testbtn);
//        layeredPane.add(test,9,10);


        btn_start = new JButton("start");
        btn_start.setVisible(false);
        btn_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layeredPane.getComponent(layeredPane.getIndexOf(startRequireView.getPanel())).setVisible(true);
                layeredPane.getComponent(layeredPane.getIndexOf(btn_start)).setVisible(false);
            }
        });
        btn_start.setBounds(WIDTH/2 - 50,HEIGHT/2-25,100,50);
        layeredPane.add(btn_start,1,1);

        layeredPane.add(startRequireView.getPanel(),1,2);
    }


    public void doStartRequire()
    {
        btn_start.setVisible(true);
        while (!startRequireView.isOver())
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    private void initChoixView()
    {
        layeredPane.add(choixView.getPanel(),10,3);
        choixView.setVisible(true);
    }

    public void doChoixView()
    {
        choixView.getPanel().setVisible(true);
        while (!choixView.isOver())
        {
            try {
//                System.out.println("do choix view");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cardRef.setPosition(WIDTH/2 - cardRef.getW()/2,HEIGHT/2 - cardRef.getH()/2 - 150);
        cardRef.setVisible(true);
        ref_x = cardRef.getX();
        ref_y = cardRef.getY();
        ref_w = cardRef.getW();
        ref_h = cardRef.getH();
//        cardRef.setVisible(false);
    }


    public ArrayList<JoueurBref> getJoueurChoix()
    {
        return choixView.getJoueurs();
    }


    private void initMakeOfferView()
    {
//        makeOfferView.setVisible(true);
        layeredPane.add(makeOfferView,12,12);
    }
    public static void doMakeOfferView(Joueur joueur)
    {
//        clearCardsOnTable();

        makeOfferView.setVisible(true);
        makeOfferView.afficherJoueur(joueur);

        for (Component component : layeredPane.getComponentsInLayer(joueur.getId()*10))
        {
            layeredPane.remove(component);
        }

        while (!makeOfferView.isOver())
        {
            try {
                Thread.sleep(200);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void makeOfferViewFini(ArrayList<Joueur> joueurs)
    {
        for (Joueur joueur : joueurs)
        {
            for (Component component : layeredPane.getComponentsInLayer(joueur.getId()*10))
            {
                layeredPane.remove(component);
            }
        }

        makeOfferView.afficherResultatMakeOffer(joueurs);
        while (!makeOfferView.isOver2())
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void initTakeCardView()
    {
        layeredPane.add(takeCardView,15,15);

    }

    public static void doTakeCardView(Joueur joueur,ArrayList<Carte>offers)
    {
        takeCardView.setVisible(true);
        takeCardView.takeCardOnTable(joueur,offers);
        layeredPane.revalidate();
        layeredPane.repaint();
        while (!takeCardView.isOver())
        {
            try{
                Thread.sleep(200);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        takeCardView.setVisible(false);
    }
    public static int getTakeCardChoix(){return takeCardView.getChoix();}



    public static int getChoixDeJoueur(Joueur joueur)
    {
        return makeOfferView.getChoix(joueur);
    }


    private void initFinDeJeuView()
    {

        layeredPane.add(finDeJeuView.getPanel(),10,10);     // le niveau doit etre change apres.
    }

    public void doFinDeJeu(Object [][] resultat)
    {
//        System.out.println("---------------------------------------------");
        layeredPane.add(finDeJeuView.getPanel(),100,10);
        finDeJeuView.setVisible(true);
//        System.out.println(resultat.length);
        for (int i=0;i<resultat.length;i++)
        {
//            System.out.println((String)resultat[i][0]+(Integer)resultat[i][1]);
            finDeJeuView.addData((String)resultat[i][0],(Integer)resultat[i][1]);
        }
        finDeJeuView.getPanel().setVisible(true);

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


    public static void afficherNomJoueur(ArrayList<Joueur> joueurs)
    {
        int init_x = 0;
        int init_y = 0;
        int index = 20;
        for (Joueur joueur : joueurs) {
            if (joueur.getId() == 1) {
                init_x = ViewController.WIDTH/2;
                init_y = ViewController.HEIGHT-70;
            } else if (joueur.getId() == 2) {
                init_x = 20;
                init_y = ViewController.HEIGHT/2+50;
            } else if (joueur.getId() == 3) {
                init_x = ViewController.WIDTH-200;
                init_y = ViewController.HEIGHT/2+150;
            } else if (joueur.getId() == 4) {
                init_x = ViewController.HEIGHT/2-20;
                init_y = 10;
            }
            JLabel nom = new JLabel();
            nom.setText(joueur.getName());
            nom.setBounds(init_x,init_y,100,20);
            layeredPane.add(nom,5,1);

        }

    }

    public static void afficherTrophie(ArrayList<Carte> trophie)
    {
        int intervalle = 10;
        int x = ref_x-ref_w-intervalle;
        int index = 0;
        for (Carte carte : trophie)
        {
            CardModel cardModel = new CardModel(carte,x,ref_y);
            layeredPane.add(cardModel,100,index++);
            x = ref_x + ref_w + 10;
        }
    }

    public static void clearCardsOnTable()
    {
        for (Component component : layeredPane.getComponentsInLayer(3))
        {
            layeredPane.remove(component);
        }
    }

    public static void afficherCarteDeJoueur(Joueur joueur)
    {
//        System.out.println("afficher les cartes");
        int init_x = 0;
        int init_y = 0;
        int index = joueur.getId() * 10;
        System.out.println(layeredPane);

//        for (int i=index;i<index+2;i++)
//        {
//            if (layeredPane.getComponent(i)!=null)
//            {
//                layeredPane.remove(i);
//            }
//        }
        if (joueur.getId() == 1)
        {
            init_x = 500;
            init_y = 500;
        }
        else if (joueur.getId() == 2)
        {
            init_x = 50;
            init_y = 300;
        }
        else if (joueur.getId() == 3)
        {
            init_x = 900;
            init_y = 400;
        }
        else if (joueur.getId() == 4)
        {
            init_x = 300;
            init_y = 50;
        }

        for (int i=0;i<joueur.getCarteOffer().size();i++)
        {
            joueurCarte[joueur.getId()-1][i] = new CardModel(joueur.getCarteOffer().get(i),init_x,init_y);
            init_x += 100;
        }



        for (int i=0;i<2;i++)
        {
            CardModel cardModel = (CardModel) joueurCarte[joueur.getId()-1][i];
//            if (choixCarte[joueur.getId()-1]!=cardModel.getCarte().getId())
//            {
//                cardModel.setPosition(init_x,init_y);
//            }

            if (!cardModel.getCarte().isVisible())
            {
                cardModel.setImage(new ImageIcon("src/images/cachee.png").getImage());
            }
            cardModel.setVisible(true);
            layeredPane.add(cardModel,joueur.getId()*10,index);
            index++;
        }



    }


    public static int[] getChoixCarteNb() {
        return choixCarteNb;
    }

    public static void afficherJestFinal(ArrayList<Joueur> joueurs)
    {
        int init_x = 0;
        int init_y = 0;
        int index = 20;
        for (Joueur joueur : joueurs)
        {
            if (joueur.getId() == 1)
            {
                init_x = 400;
                init_y = 600;
            }
            else if (joueur.getId() == 2)
            {
                init_x = 50;
                init_y = 300;
            }
            else if (joueur.getId() == 3)
            {
                init_x = 900;
                init_y = 400;
            }
            else if (joueur.getId() == 4)
            {
                init_x = 300;
                init_y = 50;
            }
            for (Carte carte : joueur.getJest())
            {
                CardModel cardModel = new CardModel(carte,init_x,init_y);
                cardModel.setScale(CardModel.SCALE);
                init_x += 100;
                cardModel.setVisible(true);
                layeredPane.add(cardModel,70,index);
                index++;
            }
        }

    }

    public static void afficherJest(ArrayList<Joueur> joueurs)
    {
        int init_x = 0;
        int init_y = 0;
        int index = 20;
        for (Joueur joueur : joueurs)
        {
            if (joueur.getId() == 1)
            {
                init_x = 100;
                init_y = 600;
            }
            else if (joueur.getId() == 2)
            {
                init_x = 50;
                init_y = 500;
            }
            else if (joueur.getId() == 3)
            {
                init_x = 1000;
                init_y = 600;
            }
            else if (joueur.getId() == 4)
            {
                init_x = 50;
                init_y = 50;
            }

            for (Carte carte : joueur.getJest())
            {
                CardModel cardModel = new CardModel(carte,init_x,init_y);
                cardModel.setScale(12);
                init_x += cardModel.getH();
                cardModel.setVisible(true);
                layeredPane.add(cardModel,70,index);
                index++;
            }
        }
    }


    public int getNbJoueurs()
    {
        return startRequireView.getNbJoueurs();
    }


    public JFrame getFrame() {
        return frame;
    }
}
