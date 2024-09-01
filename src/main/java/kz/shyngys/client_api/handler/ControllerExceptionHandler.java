package kz.shyngys.client_api.handler;

import kz.shyngys.client_api.exception.not_found.AbstractNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        if (ex instanceof AbstractNotFoundException notFoundException) {
            return new ResponseEntity<>(
                    notFoundException.getEntityName() + " was not found by id " + notFoundException.getId(),
                    HttpStatus.NOT_FOUND
            );
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
    }

}
