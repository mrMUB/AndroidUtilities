package com.MrMUB.androidutilities;

import java.util.Random;

public class GenerateChar {

    private int sizeOfChar = 15;
    private String allowedChar = "0123456789qwertyuiopasdfghjklzxcvbnmABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public GenerateChar setSize(int sizeOfChar){
        this.sizeOfChar = sizeOfChar;
        return this;
    }

    public GenerateChar setAllowedChar (String allowedChar){
        this.allowedChar = allowedChar;
        return this;
    }

    public String generate(){
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfChar);
        for(int i=0;i<sizeOfChar;++i)
            sb.append(allowedChar.charAt(random.nextInt(allowedChar.length())));
        return sb.toString();
    }


}
