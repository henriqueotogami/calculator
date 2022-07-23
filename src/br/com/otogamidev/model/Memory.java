package br.com.otogamidev.model;

public class Memory {

    private static final Memory singletonInstance = new Memory();
    private String actualText = "";

    private Memory(){

    }

    public static Memory getSingletonInstance(){
        return singletonInstance;
    }


    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }



}
