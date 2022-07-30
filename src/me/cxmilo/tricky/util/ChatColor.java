package me.cxmilo.tricky.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final Pattern COLOR_PATTERN;

    static {
        COLOR_MAP = new HashMap<>();
        COLOR_PATTERN = Pattern.compile("&(.)");
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

    public static String translateColorCodes(String textToTranslate) {
        Matcher colorMatcher = COLOR_PATTERN.matcher(textToTranslate);
        while (colorMatcher.find()) {
            char colorCode = colorMatcher.group().charAt(1);
            ChatColor chatColor = COLOR_MAP.get(colorCode);
            if (chatColor == null) chatColor = ChatColor.WHITE;
            textToTranslate = textToTranslate.replaceAll("&" + colorCode, chatColor.color);
        }
        return textToTranslate;
    }
}