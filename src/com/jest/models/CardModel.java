package com.jest.models;

import com.jest.carte.Carte;

import java.awt.*;

public class CardModel extends Layer {
    private Carte carte;

    public CardModel(Image image, Carte carte, int scale) {
        super(image, scale);
        this.carte = carte;
    }

    public CardModel(Image image, int scale) {
        super(image, scale);
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
        setBounds(x,y,w,h);
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
