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
        return Query.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Query q = (Query) o;
        if (!StringUtils.hasText(q.getQuery())) errors.reject("Query empty");
    }

}
