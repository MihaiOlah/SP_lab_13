package services;

import java.awt.image.BufferedImage;

public interface ImageLoader {
    BufferedImage load(String url);
}
