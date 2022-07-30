package me.cxmilo.tricky.util;

import java.io.IOException;

public class ConsoleUtil {

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls", "clear").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Failed to clear screen", e);
        }
    }
}
