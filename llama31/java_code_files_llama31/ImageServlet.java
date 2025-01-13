/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet
extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = "Hello, World!";
        BufferedImage bufferedImage = this.generateImage(string);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)bufferedImage, "png", byteArrayOutputStream);
        byte[] byArray = byteArrayOutputStream.toByteArray();
        httpServletResponse.setContentType("image/png");
        httpServletResponse.getOutputStream().write(byArray);
    }

    private BufferedImage generateImage(String string) {
        BufferedImage bufferedImage = new BufferedImage(200, 50, 1);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawString(string, 10, 20);
        graphics2D.dispose();
        return bufferedImage;
    }

    public static void main(String[] stringArray) {
    }
}
