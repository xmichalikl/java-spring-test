package sk.uteg.springdatatest.api;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sk.uteg.springdatatest.api.exception.NotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    public static class ErrorResponse  {
        private final LocalDateTime timestamp;
        private final Integer status;
        private final String error;
        private final String path;

        public ErrorResponse (HttpStatus status, String error, String path) {
            this.timestamp = LocalDateTime.now();
            this.status = status.value();
            this.error = error;
            this.path = path.replace("uri=", "");
        }
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse > handleNotFound(NotFoundException ex, WebRequest req) {
        ErrorResponse errorResponse = new ErrorResponse (HttpStatus.NOT_FOUND, ex.getMessage(), req.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
