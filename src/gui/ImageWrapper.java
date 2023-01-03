package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWrapper {
    private final BufferedImage _oImage;
    private final int _oWidth;
    private final int _oHeight;

    public ImageWrapper(String pPath) throws IOException {
        _oImage = ImageIO.read(new File(pPath));
        _oWidth = _oImage.getWidth();
        _oHeight = _oImage.getHeight();
    }

    public Image GetResized(int pNewWidth, int pNewHeight) {
        return _oImage.getScaledInstance(pNewWidth, pNewHeight, Image.SCALE_DEFAULT);
    }

    public int GetWidth() {
        return _oWidth;
    }

    public int GetHeight() {
        return _oHeight;
    }
}