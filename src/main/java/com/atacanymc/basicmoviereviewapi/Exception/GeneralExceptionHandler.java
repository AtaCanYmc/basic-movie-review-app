package com.atacanymc.basicmoviereviewapi.Exception;

import com.atacanymc.basicmoviereviewapi.Exception.BadRequestException;
import com.atacanymc.basicmoviereviewapi.Exception.MovieNotFoundException;
import com.atacanymc.basicmoviereviewapi.Exception.ReviewNotFoundException;
import com.atacanymc.basicmoviereviewapi.Exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
    @ExceptionHandler({ReviewNotFoundException.class})
    public ResponseEntity<Object> handleReviewNotFoundException(ReviewNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({MovieNotFoundException.class})
    public ResponseEntity<Object> handleMovieNotFoundException(MovieNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}