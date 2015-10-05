package com.company;

import java.awt.*;

public class Rgb {
    private int r;
    private int g;
    private int b;
    public Rgb(int r,int g,int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public int toInt(){
        return  new Color(r, g, b).getRGB();
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
        if(r<0)this.r=0;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
        if(g<0)this.g=0;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        if(b<0)this.b=0;
    }
}
