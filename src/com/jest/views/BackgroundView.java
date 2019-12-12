package com.jest.views;

import com.jest.models.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class BackgroundView extends JPanel{
    private Background background;
    private Image image;
    private static final int SCALE = 1;
    public BackgroundView(int w,int h) {
//        File file = new File("src/images/desk.jpg");
//        BufferedImage bufferedImage = null;
//        try {
//            InputStream inputStream = new FileInputStream(file);
//            bufferedImage = ImageIO.read(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        image = new ImageIcon("src/images/desk.jpg").getImage();
//        background = new Background(0,0,image,SCALE);
        setBounds(0,0,w,h);
    }

    public void paint(Graphics graphics)
    {
        graphics.drawImage(this.image,0,0,null);
    }
}
