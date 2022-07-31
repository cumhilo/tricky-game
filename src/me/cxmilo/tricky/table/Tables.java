package me.cxmilo.tricky.table;

import me.cxmilo.tricky.coordinate.Coordinate;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.User;
import me.cxmilo.tricky.util.ChatColor;

import java.util.Optional;

public class Tables {

    /**
     * Prints the table.
     *
     * @param table the table to print.
     */
    public static void printTable(Table table) {
        for (Point point : table.points()) {
            Coordinate coordinate = point.getCoordinate();
            if (coordinate.getNumber() % table.size() == 0) {
                System.out.println();
            }

            if (point.getOwner().isPresent()) {
                Optional<User> owner = point.getOwner();
                System.out.print(ChatColor.translateColorCodes(" &b" + owner.get().getDecorator() + "&r "));
                continue;
            }
            System.out.print(" # ");
        }
    }
}
