package br.com.otogamidev.model;

@FunctionalInterface
public interface ObserverMemory {
    void changeValue(final String newValue);
}
