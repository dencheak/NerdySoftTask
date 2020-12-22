package denis.lishchuk.java_test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AtLeastFourPointsArePresentConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastFourPointsArePresent{
    public String message() default "Must be at least 4 points";

    public Class<?> [] groups() default {};

    public Class<?extends Payload> [] payload() default{};
}
