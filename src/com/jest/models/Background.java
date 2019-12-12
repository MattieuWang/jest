package com.jest.models;

import javax.swing.*;
import java.awt.*;

public class Background extends Layer {
    public Background(int x, int y,Image image, int scale) {
        super(x, y, image, scale);
    }

    public void paint(Graphics g) {
        g.drawImage(this.image,x,y,x+w,y+w,0,0,image.getWidth(null),image.getHeight(null),null);
    }
}
