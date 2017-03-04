package sda24.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


import java.net.BindException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getCode().toString())
                .collect(Collectors.toList());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    public String bindExceptionHandler(BindException ex) {
        return ex.getMessage();
    }


}
