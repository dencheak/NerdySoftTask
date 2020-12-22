package denis.lishchuk.java_test.validators;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.exception.CustomValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AtLeastFourPointsArePresentConstraintValidator implements ConstraintValidator<AtLeastFourPointsArePresent, List<Point>> {
    @Override
    public boolean isValid(List<Point> points, ConstraintValidatorContext constraintValidatorContext)throws CustomValidationException {
        int i=0;
        for (Point p: points) {
            i++;
        }
        if(i>=4)
            return true;
        else return false;
//        else throw new CustomValidationException("Must be more points");
    }
}
