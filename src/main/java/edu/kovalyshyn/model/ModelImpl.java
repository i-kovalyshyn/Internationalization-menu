package edu.kovalyshyn.model;

import edu.kovalyshyn.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelImpl implements Model {
    private static Logger log = LogManager.getLogger(ModelImpl.class);

    Scanner scanner = new Scanner(System.in);
    private String sentence;
    private String input = "Please, input something: ";

    @Override
    public void readTxt() {
        for (String line : new ReadFromFile().readFromFile()) {
            log.info(line);
        }
    }

    @Override
    public void concatParam() {
        List<String> stringList = new ArrayList<>();
        System.out.println(input);
        while (!(sentence = scanner.nextLine()).isEmpty()) {
            stringList.add(sentence);
            log.info(StringUtil.concatAllParameters(stringList));
        }
        scanner.close();
    }

    @Override
    public void checkSentence() {
        System.out.println(input);
        sentence = scanner.nextLine();
        if (StringUtil.checkSentence(sentence)) {
            log.info("Sentence is in param scope");
        } else {
            log.error("Sentence under the param scope");
        }
        scanner.close();
    }

    @Override
    public void splitString() {
        System.out.println(input);
        sentence = scanner.nextLine();
        log.info(StringUtil.splitString(sentence));
    }

    @Override
    public void replaceVowels() {
        System.out.println(input);
        sentence = scanner.nextLine();
        log.info(StringUtil.replaceVowels(sentence));
    }

    @Override
    public void sortTextByWordCount() {
        List<String> orderedText = StringUtil.sortTextByWordCount(new ReadFromFile().readFromFile());
        orderedText.forEach(s -> System.out.println(s + " "));
        System.out.println();
    }
}
