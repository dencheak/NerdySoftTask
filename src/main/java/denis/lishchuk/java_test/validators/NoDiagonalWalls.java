package denis.lishchuk.java_test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoDiagonalWallsConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoDiagonalWalls {
    public String message() default "Diagonal walls";

    public Class<?> [] groups() default {};

    public Class<?extends Payload> [] payload() default{};
}
