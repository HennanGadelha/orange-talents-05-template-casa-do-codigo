package br.com.casadocodigo.config.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValididacao {


    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacaoDto> handleErros(MethodArgumentNotValidException ex){

        List<ErroValidacaoDto> errosDeValidacao = new ArrayList<>();
        List<FieldError> errosPreenchimentoDeCampo = ex.getBindingResult().getFieldErrors();

        errosPreenchimentoDeCampo.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            //System.out.println(mensagem);
            ErroValidacaoDto erro = new ErroValidacaoDto(e.getField(), mensagem);
            errosDeValidacao.add(erro);
        });

        return errosDeValidacao;
    }

}
