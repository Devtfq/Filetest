package com.thawfeeqstudios.sahamedthwfeeq.filetest;

public class Product {
     private String fname;
     private String fpath;
     private String fimg;

    public Product(String fname, String fpath, String fimg) {
        this.fname = fname;
        this.fpath = fpath;
        this.fimg = fimg;
    }

    public String getfimg() {
        return fimg;
    }
    public String getfname() {
        return fname;
    }

    public String getfpath() {
        return fpath;
    }
}
