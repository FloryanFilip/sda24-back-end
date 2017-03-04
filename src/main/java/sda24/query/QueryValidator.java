package sda24.query;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by bolad on 3/4/17.
 */
@Component
public class QueryValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return QueryDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        QueryDto q = (QueryDto) o;
        if (!StringUtils.hasText(q.getQuery())) errors.reject("Query empty");
    }

}
