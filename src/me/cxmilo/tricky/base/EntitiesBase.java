package me.cxmilo.tricky.base;

import me.cxmilo.tricky.entity.User;

import java.util.Set;

public class EntitiesBase
        implements Base {

    private final Set<User> userEntities;

    public EntitiesBase(Set<User> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public void init() {
        userEntities.add(new User("Player1", (short) 0, 'X'));
        userEntities.add(new User("Player2", (short) 1, 'O'));
    }

    @Override
    public void shutdown() {
        userEntities.clear();
    }
}
