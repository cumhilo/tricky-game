package me.cxmilo.tricky.entity;

import java.util.Optional;
import java.util.Set;

public class Entities {

    private final Set<? extends Entity> entities;

    public Entities(Set<? extends Entity> entities) {
        this.entities = entities;
    }

    /**
     * Get a entity by its id.
     *
     * @param id The id of the entity.
     * @return The entity with the given id.
     */
    public Optional<? extends Entity> findEntity(int id) {
        Optional<? extends Entity> optionalEntity = Optional.empty();

        for (Entity entity : entities) {
            if (entity.getId() == id) {
                optionalEntity = Optional.of(entity);
                break;
            }
        }

        return optionalEntity;
    }
}
