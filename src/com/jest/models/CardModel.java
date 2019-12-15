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
    private static final int SCALE = 5;

    public CardModel(Image image, Carte carte) {
        this.carte = carte;
        this.x=0;
        this.y=0;
        this.image = image;
        this.w = image.getWidth(null)/SCALE;
        this.h = image.getHeight(null)/SCALE;
    }

    public CardModel(Image image) {
        this.x=0;
        this.y=0;
        this.image = image;
        this.w = image.getWidth(null)/SCALE;
        this.h = image.getHeight(null)/SCALE;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        setBounds(x,y,w+x,h+y);
        System.out.println(x+"  "+y);
    }

    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.image,x,y,x+w,y+w,0,0,image.getWidth(null),image.getHeight(null),null);

    }
}
