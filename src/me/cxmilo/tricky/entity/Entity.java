package me.cxmilo.tricky.entity;

import me.cxmilo.tricky.component.Component;

import java.util.Set;

public interface Entity
        extends IdentifiableEntity {

    /**
     * Get the components of the entity.
     *
     * @return The components of the entity.
     */
    Set<Component> getComponents();
}
