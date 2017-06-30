package com.example.anrou_hu.sticky.utils;

/**
 * @author anrou_hu
 */

public class Preconditions {


    public static <T> T checkNotNull(T reference){
        if(reference == null){
            throw  new NullPointerException();
        }else {
            return reference;
        }
    }
}
