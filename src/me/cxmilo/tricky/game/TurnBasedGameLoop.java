package me.cxmilo.tricky.game;

import me.cxmilo.tricky.entity.Entities;
import me.cxmilo.tricky.util.ChatColor;

import java.util.Scanner;

public class TurnBasedGameLoop extends GameLoop {

    private static final Scanner SCANNER = new Scanner(System.in);

    public TurnBasedGameLoop(Game game) {
        super(game);
    }

    @Override
    protected void processGameLoop() {
        while (isGameRunning()) {
            controller.printTable();
            var entities = new Entities(game.entities());
            entities.findEntity(game.getTurn()).ifPresent(entity -> logger.info(ChatColor.translateColorCodes("&a" + entity.getName() + ", please enter a cell to mark&r")));

            String next = SCANNER.nextLine();

            if (next == null || next.isBlank() || next.isEmpty()) {
                logger.info(ChatColor.translateColorCodes("&c" + next + " isn't a valid input, please try again!&r"));
                continue;
            }

            int parsedInput;

            try {
                parsedInput = Integer.parseInt(next);
            } catch (NumberFormatException exception) {
                logger.severe(ChatColor.translateColorCodes("&c" + next + " isn't a valid input, please try again!&r"));
                continue;
            }

            if (!controller.score(parsedInput)) {
                logger.severe(parsedInput + " has already been marked, please try again!");
                continue;
            }
            controller.updateTurn();
        }
    }
}
