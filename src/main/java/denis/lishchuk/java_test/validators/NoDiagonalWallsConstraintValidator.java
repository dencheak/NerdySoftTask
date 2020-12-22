package denis.lishchuk.java_test.validators;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.entity.Room;
import denis.lishchuk.java_test.exception.CustomValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.util.List;

public class NoDiagonalWallsConstraintValidator implements ConstraintValidator<NoDiagonalWalls, List<Point>> {
    @Override
    public boolean isValid(List<Point> points, ConstraintValidatorContext cvx) throws CustomValidationException{
        for(int i=0;i<points.size();i++){
            if(i==0){
                if((points.get(i).getX().equals(points.get(points.size()-1).getX()))==(points.get(i).getY().equals(points.get(points.size()-1).getY()))) {
                   return false;
//                    throw new CustomValidationException("Diagonal walls");
                }
            }
            else{
                if(((points.get(i).getX().equals(points.get(i-1).getX()))==(points.get(i).getY().equals(points.get(i-1).getY())))) {
                   return false;
                    //throw new CustomValidationException("Diagonal walls");
                }
            }
        }
        return true;
    }
}
