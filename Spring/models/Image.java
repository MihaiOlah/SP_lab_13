package Spring.models;

import services.ImageLoader;
import services.ImageLoaderFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Image extends Element implements Picture, Visitee {
    private final String url_;
    private final BufferedImage content_;

    public Image(String url)
    {
        if (url != null)
            url_ = url;
        else
            url_ = "";

        ImageLoader imageLoader = (new ImageLoaderFactory()).create(url);

        if (imageLoader != null)
        {
            content_ = imageLoader.load(url_);
        }
        else
        {
            content_ = null;
        }
    }

    public Image(Image image)
    {
        url_ = image.url_;
        content_ = image.content_;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public BufferedImage getContent()
    {
        return content_;
    }

    @Override
    public String url()
    {
        return url_;
    }

    @Override
    public Dimension dim()
    {
        return new Dimension();
    }

    public BufferedImage content()
    {
        return content_;
    }

    public void display()
    {
        if (content_ != null)
        {
            JLabel picLabel = new JLabel(new ImageIcon(content_));
            JPanel jPanel = new JPanel();
            jPanel.add(picLabel);
            JFrame f = new JFrame();
            f.setSize(new Dimension(content_.getWidth(), content_.getHeight()));
            f.add(jPanel);
            f.setVisible(true);
        }
        else
        {
            System.out.println("Something went wrong");
        }
    }

    public String getUrl() { return url_; }

    @Override
    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    };

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitImage(this);
    }
}
