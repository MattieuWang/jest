package com.jest.models;

import com.jest.carte.Carte;

import javax.swing.*;
import java.awt.*;

public class CardModel extends JPanel {
    private Carte carte;
    private Image image;
    private int x;
    private int y;
    private int w;
    private int h;
    public static final int SCALE = 8;


    public CardModel(Image image, Carte carte) {
        this.carte = carte;
        this.x=0;
        this.y=0;
        this.image = image;
        this.w = image.getWidth(null)/SCALE;
        this.h = image.getHeight(null)/SCALE;
        setBounds(x,y,w,h);
    }

    public CardModel(Carte carte,int x,int y) {
        this.carte = carte;
        this.x=x;
        this.y=y;
        this.image = new ImageIcon(carte.getImageLocation()).getImage();
        this.w = image.getWidth(null)/SCALE;
        this.h = image.getHeight(null)/SCALE;
        setBounds(x,y,w,h);
    }


    public CardModel(Image image) {
        this.x=0;
        this.y=0;
        this.image = image;
        this.w = image.getWidth(null)/SCALE;
        this.h = image.getHeight(null)/SCALE;
//        setBounds(x,y,w,h);
        setBounds(x,y,w,h);
    }


    public void setScale(int scale)
    {
        w = image.getWidth(null) / scale;
        h = image.getHeight(null) / scale;
        setBounds(x,y,w,h);
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        setBounds(x,y,w,h);
//        System.out.println(x+"  "+y);
    }

    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setVisi(boolean visi)
    {
        if (visi)
        {
            image = new ImageIcon(carte.getImageLocation()).getImage();
            carte.setVisible(true);
        }
        else
        {
            image = new ImageIcon("src/images/cachee.png").getImage();
            carte.setVisible(false);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.image,0,0,w,h,0,0,image.getWidth(null),image.getHeight(null),null);
//        g.drawImage(this.image,x,y,null);

    }
}
