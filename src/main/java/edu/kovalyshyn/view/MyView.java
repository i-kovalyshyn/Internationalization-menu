package edu.kovalyshyn.view;

import edu.kovalyshyn.controller.Controller;
import edu.kovalyshyn.controller.ControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MyView {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);
    private static Logger log = LogManager.getLogger(MyView.class);
    private Locale locale;
    private ResourceBundle bundle;

    private void setMenu() {
        controller = new ControllerImpl();
        menu = new LinkedHashMap<>();
        menu.put("1", bundle.getString("1"));
        menu.put("2", bundle.getString("2"));
        menu.put("3", bundle.getString("3"));
        menu.put("4", bundle.getString("4"));
        menu.put("5", bundle.getString("5"));
        menu.put("6", bundle.getString("6"));
        menu.put("7", bundle.getString("7"));
        menu.put("8", bundle.getString("8"));
        menu.put("9", bundle.getString("9"));
        menu.put("10", bundle.getString("10"));
        menu.put("Q", bundle.getString("Q"));
    }

    public MyView() {
        locale = new Locale("en");
        bundle = ResourceBundle.getBundle("Menu", locale);
        setMenu();
        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
        methodsMenu.put("6", this::pressButton6);
        methodsMenu.put("7", this::internationalizeMenuEnglish);
        methodsMenu.put("8", this::internationalizeMenuJapanese);
        methodsMenu.put("9", this::internationalizeMenuGreek);
        methodsMenu.put("10", this::internationalizeMenuUkrainian);
    }

    private void pressButton1() {
        controller.readTxt();
    }

    private void pressButton2() {
        controller.concatParam();
    }

    private void pressButton3() {
        controller.checkSentence();
    }

    private void pressButton4() {
        controller.splitString();
    }
    private void pressButton5() {
        controller.replaceVowels();
    }
    private void pressButton6() {
        controller.sortTextByWordCount();
    }

    private void internationalizeMenuEnglish() {
        locale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("Menu", locale);
        setMenu();
        show();
    }

    private void internationalizeMenuJapanese() {
        locale = new Locale("ja", "JA");
        bundle = ResourceBundle.getBundle("Menu", locale);
        setMenu();
        show();
    }

    private void internationalizeMenuGreek() {
        locale = new Locale("el", "EL");
        bundle = ResourceBundle.getBundle("Menu", locale);
        setMenu();
        show();
    }

    private void internationalizeMenuUkrainian() {
        locale = new Locale("uk", "UA");
        bundle = ResourceBundle.getBundle("Menu", locale);
        setMenu();
        show();
    }

    private void outputMenu() {
        System.out.println("\n MENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                log.info("-EXIT- ");
            }
        } while (!keyMenu.equals("Q"));
    }
}
