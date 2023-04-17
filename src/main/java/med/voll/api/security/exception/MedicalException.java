package med.voll.api.security.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class MedicalException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treatError400(MethodArgumentNotValidException ex) {
        List<FieldError> error = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(error.stream().map(dataValidationError::new).toList());
    }

    private record dataValidationError(String field, String message) {
        public dataValidationError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
