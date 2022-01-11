package Spring.models;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

@Entity
public class ImageProxy extends Element implements Picture, Visitee {
    private String url_;
    private final Dimension dim_;
    @Transient
    private Image realImage_;

    public ImageProxy()
    {
        url_ = "";
        dim_ = new Dimension(0, 0);
        realImage_ = null;
    }

    public ImageProxy(String url)
    {
        if (url != null)
            url_ = url;
        else
            url_ = "";
        dim_ = new Dimension(0, 0);
        realImage_ = null;
    }

    public Image loadImage()
    {
        if (realImage_ == null)
        {
            realImage_ = new Image(url_);
        }

        return realImage_;
    }

    public Image getRealImage() {
        return realImage_;
    }

    public String getUrl()
    {
        return url_;
    }

    public void setRealImage(Image image)
    {
        realImage_ = new Image(image);
    }

    @Override
    public String url()
    {
        return url_;
    }

    @Override
    public Dimension dim()
    {
        return dim_;
    }

    @Override
    public BufferedImage content()
    {
        return realImage_.getContent();
    }

    public boolean add(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Element element)
    {
        throw new UnsupportedOperationException();
    }

    public Element get(int index)
    {
        throw new UnsupportedOperationException();
    }

    public Element getDocument()
    {
        throw new UnsupportedOperationException();
    }

    public void setNewValue(String newValue)
    {
        url_ = newValue;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitImageProxy(this);
    }
}
