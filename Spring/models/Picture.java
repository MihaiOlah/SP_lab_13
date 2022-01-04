package Spring.models;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Picture {
    String url();
    Dimension dim();
    BufferedImage content();
}
