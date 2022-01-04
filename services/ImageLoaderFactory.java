package services;

public class ImageLoaderFactory {
    public ImageLoaderFactory()
    {
    }

    public ImageLoader create(String type)
    {
        if (type == null)
        {
            return null;
        }

        if (type.endsWith("jpg"))
        {
            return new JPGImageLoader();
        }
        else if(type.endsWith("bmp") || type.endsWith("dib"))
        {
            return new BMPImageLoader();
        }
        else
        {
            return null;
        }
    }
}
