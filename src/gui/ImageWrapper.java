package gui;

import constants.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWrapper {
    private final BufferedImage _originalImage;
    private final int _originalWidth;
    private final int _originalHeight;

    private BufferedImage _currentImage;
    private int _currentWidth;
    private int _currentHeight;

    public ImageWrapper(String pPath) throws IOException {
        _originalImage = ImageIO.read(new File(pPath));
        _originalWidth = _originalImage.getWidth();
        _originalHeight = _originalImage.getHeight();

        this._iResize(_originalWidth, _originalHeight);
    }

    private static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bImage;
    }

    private void _iResize(int pNewWidth, int pNewHeight) {
        _currentImage = toBufferedImage(_originalImage.getScaledInstance(pNewWidth, pNewHeight, Constants.MAP_SCALING_ALGORITHM));
        _currentWidth = pNewWidth;
        _currentHeight = pNewHeight;
    }

    public ImageWrapper Rotate(double pAngle) {
        // Rotation information
        double rotationRequired = Math.toRadians(pAngle);
        double locationX = _currentWidth / 2;
        double locationY = _currentHeight / 2;

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        // Drawing the rotated image at the required drawing locations
        _currentImage = op.filter(_currentImage, null);

        return this;
    }

    public ImageWrapper Resize(int pNewWidth, int pNewHeight) {
        _iResize(pNewWidth, pNewHeight);

        return this;
    }

    public Image GetOriginalImage() {
        return _originalImage;
    }

    public int GetOriginalWidth() {
        return _originalWidth;
    }

    public int GetOriginalHeight() {
        return _originalHeight;
    }

    public Image GetCurrentImage() {
        return _currentImage;
    }

    public int GetCurrentWidth() {
        return _currentWidth;
    }

    public int GetCurrentHeight() {
        return _currentHeight;
    }
}