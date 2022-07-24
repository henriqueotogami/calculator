package br.com.otogamidev.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static final Memory singletonInstance = new Memory();
    private final List<ObserverMemory> observers = new ArrayList<>();
    private String actualText = "";

    private Memory(){

    }

    public List<ObserverMemory> getObservers() {
        return observers;
    }

    public void setActualText(String actualText) {
        this.actualText = actualText;
    }

    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public static Memory getSingletonInstance(){
        return singletonInstance;
    }

    public void addObserver(final ObserverMemory observer) {
        getObservers().add(observer);
    }

    public void processCommand(final String newValue) {
        setActualText(getActualText().concat(newValue));
        getObservers().forEach(observer -> observer.changeValue(getActualText()));
    }

}
