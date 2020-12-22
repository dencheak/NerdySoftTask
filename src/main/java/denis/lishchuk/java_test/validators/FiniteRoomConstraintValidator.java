package denis.lishchuk.java_test.validators;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.exception.CustomValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.List;

public class FiniteRoomConstraintValidator implements ConstraintValidator<FiniteRoom, List<Point>> {
    @Override
    public boolean isValid(List<Point> points, ConstraintValidatorContext constraintValidatorContext)throws CustomValidationException {
        int sum=0;
        for (int i = 0; i < points.size(); i++) {
            if(i==points.size()-1){
                sum+=(points.get(0).getX()-points.get(i).getX())*(points.get(0).getY()+points.get(i).getY());
            }
            else sum+=(points.get(i+1).getX()-points.get(i).getX())*(points.get(i+1).getY()+points.get(i).getY());
        }

        if(sum >=0)
            return true;
        else return false;
//        else throw new CustomValidationException("Infinite room");
    }
}
