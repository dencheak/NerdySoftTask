package denis.lishchuk.java_test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PointsAreIntegerConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PointsAreInteger {
    public String message() default "Points aren't integer";

    public Class<?> [] groups() default {};

    public Class<?extends Payload> [] payload() default{};
}
