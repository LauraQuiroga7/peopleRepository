package co.edu.uptc.calculator.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uptc.calculator.dto.ResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DivisionByZeroException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleDivisionByZero(
            DivisionByZeroException exception) {

        logger.error("Error de división por cero: {}",
                exception.getMessage());

        return new ResponseDTO(
            null,
            null,
            exception.getMessage()
        );
    }

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleInvalidOperation(
            InvalidOperationException exception) {

        logger.error("Operación inválida: {}",
                exception.getMessage());

        return new ResponseDTO(
            null,
            null,
            exception.getMessage()
        );
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleValidationError(
            MethodArgumentNotValidException exception) {

        logger.error("Error de validación: el valor ingresado no es válido");

        return new ResponseDTO(
            null,
            null,
            "El valor no puede ser una letra"
        );
    }
}