package me.cxmilo.tricky.game;

import me.cxmilo.tricky.coordinate.Coordinates;
import me.cxmilo.tricky.entity.UserEntity;
import me.cxmilo.tricky.table.Tables;
import me.cxmilo.tricky.util.ChatColor;
import me.cxmilo.tricky.util.ConsoleUtil;
import me.cxmilo.tricky.verifier.HorizontalVerifier;
import me.cxmilo.tricky.verifier.Verifier;
import me.cxmilo.tricky.verifier.VerticalVerifier;

public record GameController(Game game, GameLoop gameLoop) {

    public boolean score(int cell) {
        var anonymous = new Object() {
            boolean score = false;
        };

        game.entities().stream().filter(entity -> entity.getId() == game.getTurn()).findFirst().ifPresent(entity -> {
            var coordinates = new Coordinates(game.getTable());
            coordinates.getPoint(cell).ifPresent(point -> {
                if (point.getOwner().isPresent()) return;

                point.setOwner((UserEntity) entity);
                point.getOwner().ifPresent(owner -> {
                    owner.getScoredPoints().add(point);
                    if (validate(game, owner)) {
                        gameLoop.stop();
                        printTable();
                        gameLoop.logger.info(ChatColor.translateColorCodes("&d" + owner.getName() + "&b has won the game!&r"));
                    }
                });
                anonymous.score = true;
            });
        });

        return anonymous.score;
    }

    public void printTable() {
        ConsoleUtil.clearScreen();
        Tables.printTable(game.getTable());
        System.out.println();
    }

    private boolean validate(Game game, UserEntity owner) {
        // Vertical verifier
        Verifier verifier = new VerticalVerifier();
        if (verifier.verify(game, owner, owner.getScoredPoints())) {
            return true;
        }
        // Horizontal verifier
        verifier = new HorizontalVerifier();
        return verifier.verify(game, owner, owner.getScoredPoints());
    }

    public void updateTurn() {
        var nextTurn = game.getTurn() + 1;

        if (nextTurn >= game.entities().size()) {
            nextTurn = 0;
        }

        game.setTurn(nextTurn);
    }
}
