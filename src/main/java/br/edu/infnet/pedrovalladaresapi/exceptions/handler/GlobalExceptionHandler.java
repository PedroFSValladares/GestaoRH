package br.edu.infnet.pedrovalladaresapi.exceptions.handler;

import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> handleMethodNotValidException(MethodArgumentNotValidException e){
        Map<String, String> mapa = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((erro) -> {
            var nomeDoCampo = ((FieldError) erro).getField();
            var mensagem = erro.getDefaultMessage();
            mapa.put(nomeDoCampo, mensagem);
        });
        
        return ResponseBody.getByCode(HttpStatus.BAD_REQUEST, mapa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseBody> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseBody.getByCode(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseBody> handleConstraintViolationException(ConstraintViolationException e){
        var violation = e.getConstraintViolations();
        var violations = violation.stream().map(ConstraintViolation::getMessage).toList();
        return ResponseBody.getByCode(HttpStatus.BAD_REQUEST, violations);
    }
}
