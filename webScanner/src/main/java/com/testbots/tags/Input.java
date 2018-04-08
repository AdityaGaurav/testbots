package com.testbots.tags;

public class Input {

    public static boolean findHiddenAttribute(String inputElement) {
        boolean hiddenFlag = false;
        String[] subString = inputElement.substring(1, inputElement.length()-1).split(" ");
        for (String s : subString) {
            if (s.toLowerCase().contains("hidden")) {
                hiddenFlag = true;
                break;
            }
        }
        return hiddenFlag;
    }

    public static String keyAppender(String input) {
        if (findHiddenAttribute(input)) {
            input = input.substring(0,input.length()-1)+ " hidden >";
        }
        return input;
    }

    public static void main(String[] args) {
        String inputElement = "<input type=\"hidden\" name=\"country\" value=\"Norway\">";
        System.out.println(keyAppender(inputElement));
    }
}
