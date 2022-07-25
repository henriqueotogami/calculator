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
                    if(getActualText().equals("0")){ setToReplace(true); }
                case COMMA:
                    setActualText(isToReplace() ? typedValue : getActualText().concat(typedValue));
                    setToReplace(false);
                    break;
                default:
                    calculateMathOperation(commandType);
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

    private void calculateMathOperation(final CommandType commandType){
        if((getBufferedText().isEmpty()) && (getLastCommandType() == null)){
            setToReplace(true);
            setBufferedText(getActualText());
            setLastCommandType(commandType);
        } else {
            double bufferedTextCommaConversion = Double.parseDouble(getBufferedText().replace(",", "."));
            double actualTextCommaConversion = Double.parseDouble(getActualText().replace(",", "."));
            double resultMathOperation = 0;
            if(getLastCommandType().equals(CommandType.SUM)){
                resultMathOperation = (bufferedTextCommaConversion + actualTextCommaConversion);
            } else if(getLastCommandType().equals(CommandType.SUBTRACTION)){
                resultMathOperation = (bufferedTextCommaConversion - actualTextCommaConversion);
            } else if(getLastCommandType().equals(CommandType.MULTIPLICATION)) {
                resultMathOperation = (bufferedTextCommaConversion * actualTextCommaConversion);
            } else if(getLastCommandType().equals(CommandType.DIVISION)) {
                resultMathOperation = (bufferedTextCommaConversion / actualTextCommaConversion);
            }
            String resultMathToString = Double.toString(resultMathOperation).replace(".", ",");
            resultMathToString = resultMathToString.contains(",0") ? resultMathToString.replace(",0", "") : resultMathToString;
            setActualText(resultMathToString);
        }
    }

}
