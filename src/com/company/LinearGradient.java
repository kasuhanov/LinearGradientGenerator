package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LinearGradient {
    private static BufferedImage image;
    private static int width;
    private static int height;
    private static void colorPixel(int rgb, String outputFileName){
        colorPixel(rgb,outputFileName,true);
        colorPixel(rgb,outputFileName,false);
    }
    private static void colorPixel(int rgb, String outputFileName, boolean dot){
        try {
            File input;
            if(dot){
                input = new File("resources/green-dot.png");
                outputFileName+="-dot";
            }else{
                input = new File("resources/green.png");
            }
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    Color c = new Color(image.getRGB(j, i));
                    if((c.getRed()<10)&&(c.getBlue()<90)&&(c.getGreen()>223 )){
                        image.setRGB(j,i,rgb);
                    }
                }
            }
            File output = new File("result/"+outputFileName+".png");
            ImageIO.write(image, "png", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void main(String args[]) throws Exception {
        Rgb fromRgb = new Rgb(255, 255, 50);
        Rgb toRgb = new Rgb(255,0, 0);
        int steps = 10;

        int rStep=(toRgb.getR() - fromRgb.getR()) /steps;
        int gStep=(toRgb.getG() - fromRgb.getG()) /steps;
        int bStep=(toRgb.getB() - fromRgb.getB()) /steps;

        //colorPixel(curRgb.toInt(),String.valueOf(0));
        for (int i =0; i <= steps; i++) {
            colorPixel(fromRgb.toInt(),String.valueOf(i));
            fromRgb.setR(fromRgb.getR() + rStep);
            fromRgb.setG(fromRgb.getG() + gStep);
            fromRgb.setB(fromRgb.getB() + bStep);

        }

    }
}