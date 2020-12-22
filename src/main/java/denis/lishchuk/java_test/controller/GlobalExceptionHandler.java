package denis.lishchuk.java_test.controller;

import denis.lishchuk.java_test.dto.response.ErrorResponse;
import denis.lishchuk.java_test.exception.CustomValidationException;
import denis.lishchuk.java_test.exception.InputDataException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;


@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(value = {InputDataException.class})
    public ErrorResponse handleException(InputDataException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
