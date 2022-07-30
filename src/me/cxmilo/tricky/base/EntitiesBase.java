package me.cxmilo.tricky.base;

import me.cxmilo.tricky.entity.UserEntity;

import java.util.Set;

public class EntitiesBase
        implements Base {

    private final Set<UserEntity> userEntities;

    public EntitiesBase(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public void init() {
        userEntities.add(new UserEntity("Player1", (short) 0, 'X'));
        userEntities.add(new UserEntity("Player2", (short) 1, 'O'));
    }

    @Override
    public void shutdown() {
        userEntities.clear();
    }
}
