package kz.shyngys.client_api.exception.not_found;

import lombok.Getter;

@Getter
public abstract class AbstractNotFoundException extends RuntimeException {

    private static final int NOT_FOUND_PREFIX_LENGTH = 7;

    private final Object id;

    public AbstractNotFoundException(Object id) {
        this.id = id;
    }

    public String getEntityName() {
        return getClass().getSimpleName().substring(NOT_FOUND_PREFIX_LENGTH + 1);
    }

}
