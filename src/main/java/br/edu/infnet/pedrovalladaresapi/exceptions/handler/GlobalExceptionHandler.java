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
        
        //mapa.put("status", HttpStatus.BAD_REQUEST.toString());
        //mapa.put("timestamp", LocalDateTime.now().toString());

        e.getBindingResult().getAllErrors().forEach((erro) -> {
            var nomeDoCampo = ((FieldError) erro).getField();
            var mensagem = erro.getDefaultMessage();
            mapa.put(nomeDoCampo, mensagem);
        });
        
        return new ResponseEntity<ResponseBody>( ResponseBody.BadRequest(mapa), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseBody> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResponseEntity<ResponseBody>(ResponseBody.BadRequest(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseBody> handleConstraintViolationException(ConstraintViolationException e){
        var violation = e.getConstraintViolations();
        var violations = violation.stream().map(ConstraintViolation::getMessage).toList();
        return new ResponseEntity<ResponseBody>(ResponseBody.BadRequest(violations), HttpStatus.BAD_REQUEST);
    }
}
