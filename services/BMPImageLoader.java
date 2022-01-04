package services;

import services.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BMPImageLoader implements ImageLoader {

    public BMPImageLoader()
    {
    }

    @Override
    public BufferedImage load(String url)
    {
        try {
            return ImageIO.read(new File(url));
        }
        catch (Exception e)
        {
            System.out.println("Could not load BMP image");
            return null;
        }
    }

    public void print(String url)
    {
        BufferedImage myPicture = this.load(url);
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
