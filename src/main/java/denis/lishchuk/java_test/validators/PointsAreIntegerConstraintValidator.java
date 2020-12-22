package denis.lishchuk.java_test.validators;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.exception.CustomValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.util.List;

public class PointsAreIntegerConstraintValidator implements ConstraintValidator<PointsAreInteger, List<Point>> {
    @Override
    public boolean isValid(List<Point> points, ConstraintValidatorContext constraintValidatorContext) throws CustomValidationException{
        for (Point p: points) {
            if(!(p.getX() instanceof Integer) || p.getX()==null) {
                return false;
//                throw new CustomValidationException("Points must be Integer");
            }
            if(!(p.getY() instanceof Integer) || p.getY()==null) {
                return false;
//                throw new CustomValidationException("Points must be Integer");
            }
        }
        return true;
    }
}
