package me.cxmilo.tricky.table;

import me.cxmilo.tricky.coordinate.Coordinate;
import me.cxmilo.tricky.entity.UserEntity;
import me.cxmilo.tricky.util.ChatColor;

import java.util.Comparator;
import java.util.Optional;

public class Tables {

    public static void printTable(Table table) {
        table.points().stream().sorted(Comparator.comparingInt(value -> value.getCoordinate().getNumber())).forEachOrdered(point -> {
            Coordinate coordinate = point.getCoordinate();
            if (coordinate.getNumber() % table.size() == 0) {
                System.out.println();
            }

            if (point.getOwner().isPresent()) {
                Optional<UserEntity> owner = point.getOwner();
                System.out.print(ChatColor.translateColorCodes(" &b" + owner.get().getDecorator() + "&r "));
                return;
            }
            System.out.print(" # ");
        });
    }
}
