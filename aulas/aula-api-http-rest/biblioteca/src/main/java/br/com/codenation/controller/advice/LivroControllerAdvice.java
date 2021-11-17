package br.com.codenation.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LivroControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class) // qual classe de exceção o método irá tratar
    @ResponseStatus(HttpStatus.BAD_REQUEST) // bean validations
    @ResponseBody // qual o tipo da response (nesse caso uma string) - colocar (entity)JSON
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // busca o que estamos buscando na request("/livro") - pega o erro da entity que criamos com beans valid
        return ex.getBindingResult().getFieldError().getField() + " - " + ex.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception ex) {
        return "Internal Server Error: " + ex.getMessage();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }


}
