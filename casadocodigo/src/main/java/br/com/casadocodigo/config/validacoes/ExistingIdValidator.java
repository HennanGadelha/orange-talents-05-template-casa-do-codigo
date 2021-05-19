package br.com.casadocodigo.config.validacoes;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistingIdValidator implements ConstraintValidator<ExistingId, Object> {

    private String atributo;
    private Class<?> entidadeDominio;
    @PersistenceContext
    private EntityManager em;


    @Override
    public void initialize(ExistingId params) {
        atributo = params.fieldName();
        entidadeDominio = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT 1 FROM  " + entidadeDominio.getName() + " WHERE "
        + atributo + "=:value");
        query.setParameter("value", value);
        List<?> resultQuery = query.getResultList();
        boolean entidadeExistente = !resultQuery.isEmpty();
        return entidadeExistente;
    }
}
