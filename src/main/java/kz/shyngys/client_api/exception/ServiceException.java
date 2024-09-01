package kz.shyngys.client_api.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    /**
     * Тип ошибки
     */
    private final ExceptionType type;

    /**
     * Описание ошибки
     */
    private final String description;

    public ServiceException(ExceptionType type, String description) {
        super(type + " :: " + description);
        this.type = type;
        this.description = description;
    }

}
