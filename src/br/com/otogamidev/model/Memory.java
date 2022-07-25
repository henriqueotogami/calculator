package br.com.otogamidev.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static final Memory singletonInstance = new Memory();
    private final List<ObserverMemory> observers = new ArrayList<>();
    private CommandType lastCommandType = null;
    private boolean toReplace = false;
    private String actualText = "";
    private String bufferedText = "";

    private Memory(){ }

    private enum CommandType { RESET, NUMBER, DIVISION, MULTIPLICATION, SUM, SUBTRACTION, EQUAL, COMMA; };

    public static Memory getSingletonInstance(){
        return singletonInstance;
    }

    public List<ObserverMemory> getObservers() { return observers; }

    public void addObserver(final ObserverMemory observer) {
        getObservers().add(observer);
    }

    public CommandType getLastCommandType() { return lastCommandType; }

    public void setLastCommandType(final CommandType lastCommandType) { this.lastCommandType = lastCommandType; }

    public boolean isToReplace() { return toReplace; }

    public void setToReplace(final boolean toReplace) { this.toReplace = toReplace; }

    public void setActualText(final String actualText) { this.actualText = actualText; }

    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public String getBufferedText() { return bufferedText; }

    public void setBufferedText(final String bufferedText) { this.bufferedText = bufferedText; }

    public void processCommand(final String typedValue) {
        CommandType commandType = detectCommandType(typedValue);
        if(commandType == null){
            return;
        } else {
            switch(commandType){
                case RESET:
                    setActualText("");
                    setBufferedText("");
                    setToReplace(false);
                    setLastCommandType(null);
                    break;
                case NUMBER:
                    if(getActualText().equals("0")){
                        setToReplace(true);
                    }
                case COMMA:
                    setActualText(isToReplace() ? typedValue : getActualText().concat(typedValue));
                    setToReplace(false);
                    break;
                case DIVISION:
                    setActualText("");
                    break;
                case MULTIPLICATION:
                    setActualText("");
                    break;
                case SUM:
                    setActualText("");
                    break;
                case SUBTRACTION:
                    setActualText("");
                    break;
                case EQUAL:
                    setActualText("");
                    break;
            }
        }
        getObservers().forEach(observer -> observer.changeValue(getActualText()));
    }

    private CommandType detectCommandType(final String valueToBeVerified){
        try{
            Integer.parseInt(valueToBeVerified);
            return CommandType.NUMBER;
        } catch (NumberFormatException numberFormatException){
            if(valueToBeVerified.equals("AC")){
                return CommandType.RESET;
            } else if (valueToBeVerified.equals("/")){
                return CommandType.DIVISION;
            } else if (valueToBeVerified.equals("X")){
                return CommandType.MULTIPLICATION;
            } else if (valueToBeVerified.equals("+")){
                return CommandType.SUM;
            } else if (valueToBeVerified.equals("-")){
                return CommandType.SUBTRACTION;
            } else if (valueToBeVerified.equals("=")){
                return CommandType.EQUAL;
            } else if ((valueToBeVerified.equals(",")) && (getActualText().contains(",") == false)){
                return CommandType.COMMA;
            }
        }
        return null;
    }

}
