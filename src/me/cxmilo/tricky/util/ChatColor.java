package me.cxmilo.tricky.util;

import java.util.HashMap;
import java.util.Map;

public enum ChatColor {
    BLACK('0', "\u001B[30m"),
    BLUE('1', "\033[34m"),
    GREEN('a', "\u001B[32m"),
    AQUA('b', "\033[36m"),
    RED('c', "\u001B[31m"),
    PURPLE('d', "\u001B[35m"),
    YELLOW('e', "\u001B[33m"),
    WHITE('f', "\033[37m"),
    BOLD('l', "\u001B[1m"),
    UNDERLINE('n', "\u001B[4m"),
    ITALIC('o', "\u001B[3m"),
    RESET('r', "\u001B[0m");

    private static final Map<Character, ChatColor> COLOR_MAP;

    static {
        COLOR_MAP = new HashMap<>();
        for (ChatColor chatColor : ChatColor.values()) {
            COLOR_MAP.put(chatColor.code, chatColor);
        }
    }

    private final char code;
    private final String color;

    ChatColor(char code, String color) {
        this.code = code;
        this.color = color;
    }

    /**
     * Translate all color codes in the given string with the corresponding color.
     *
     * @param translateText The text to replace with color codes.
     * @return the text translated with colors.
     */
    public static String translate(String translateText) {
        var charArray = translateText.toCharArray();
        int currentIndex = 0;
        int charSize = charArray.length;

        for (char character : charArray) {
            int nextIndex = currentIndex + 1;
            if (character == '&' && charSize > nextIndex) {
                char nextChar = charArray[nextIndex];
                var chatColor = COLOR_MAP.get(nextChar);
                if (chatColor == null) continue;
                translateText = translateText.replace("&" + nextChar, chatColor.color);
            }
            currentIndex++;
        }
        return clause(translateText);
    }

    /**
     * Clause the given text with the reset color code.
     *
     * @param textToReset the text to clause.
     * @return the clause text.
     */
    private static String clause(String textToReset) {
        return textToReset + RESET.color;
    }
}