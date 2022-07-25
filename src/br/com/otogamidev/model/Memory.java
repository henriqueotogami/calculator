package br.com.otogamidev.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static final Memory singletonInstance = new Memory();
    private final List<ObserverMemory> observers = new ArrayList<>();
    private String actualText = "";

    private Memory(){

    }

    private enum CommandType { RESET, NUMBER, DIVISION, MULTIPLICATION, SUM, SUBTRACTION, EQUAL, COMMA; };

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
        CommandType commandType = detectCommandType(newValue);
        System.out.println(commandType);
        setActualText(getActualText().concat(newValue));
        getObservers().forEach(observer -> observer.changeValue(getActualText()));
    }

    private CommandType detectCommandType(final String valueToBeVerified){
        try{
            Integer.parseInt(valueToBeVerified);
            return CommandType.NUMBER;
        } catch (NumberFormatException numberFormatException){
            if("AC".equals(valueToBeVerified)){
                return CommandType.RESET;
            } else if ("/".equals(valueToBeVerified)){
                return CommandType.DIVISION;
            } else if ("X".equals(valueToBeVerified)){
                return CommandType.MULTIPLICATION;
            } else if ("+".equals(valueToBeVerified)){
                return CommandType.SUM;
            } else if ("-".equals(valueToBeVerified)){
                return CommandType.SUBTRACTION;
            } else if ("=".equals(valueToBeVerified)){
                return CommandType.EQUAL;
            } else if (",".equals(valueToBeVerified)){
                return CommandType.COMMA;
            }
        }
        return null;
    }

}
