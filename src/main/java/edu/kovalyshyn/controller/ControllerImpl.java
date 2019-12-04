package edu.kovalyshyn.controller;

import edu.kovalyshyn.model.Model;
import edu.kovalyshyn.model.ModelImpl;

public class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl() {
        model = new ModelImpl();
    }


    @Override
    public void readTxt() {
        model.readTxt();
    }

    @Override
    public void concatParam() {
        model.concatParam();
    }

    @Override
    public void checkSentence() {
        model.checkSentence();
    }

    @Override
    public void splitString() {
        model.splitString();
    }

    @Override
    public void replaceVowels() {
        model.replaceVowels();
    }

    @Override
    public void sortTextByWordCount() {
        model.sortTextByWordCount();

    }


}
