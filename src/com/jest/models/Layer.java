package com.jest.models;

import javax.swing.*;
import java.awt.*;

public abstract class Layer extends JPanel {
    protected int x;
    protected int y;
    protected int h;
    protected int w;
    protected Image image;
    protected int scale;

    protected Layer(int x, int y, Image image,int scale)
    {
        this.scale = scale;
        this.x = x;
        this.y = y;
        this.image = image;
        this.w = image.getWidth(null)/scale;
        this.h = image.getHeight(null)/scale;
        setBounds(x,y,w+x,y+h);
    }

    protected Layer (Image image,int scale)     // pour carte, facile à changer sa taille
    {
        this.image = image;
        this.w = image.getWidth(null)/scale;
        this.h = image.getHeight(null)/scale;
        setBounds(0,0,w,h);
        setVisible(false);
    }

    public void changePosition(int x,int y)
    {
        this.x = x;
        this.y = y;
        setBounds(x,y,w+x,h+y);
    }

    public abstract void paint(Graphics g);


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


}
