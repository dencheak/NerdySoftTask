package denis.lishchuk.java_test.validators;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.exception.CustomValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.util.List;

public class WallsDoNotIntersectConstraintValidator implements ConstraintValidator<WallsDoNotIntersect, List<Point>> {
    @Override
    public boolean isValid(List<Point> points, ConstraintValidatorContext constraintValidatorContext) throws CustomValidationException{
        for (int i = 0; i < points.size()-2; i++) {
            for (int j = i+2; j < points.size(); j++) {
                if(j==points.size()-1){
                    if(i!=0 && solvingLinearEquation(points.get(i), points.get(i+1), points.get(j), points.get(0))) {
                        return false;
//                        throw new CustomValidationException("the walls cannot intersect");
                    }
                }else{
                    if(solvingLinearEquation(points.get(i), points.get(i+1), points.get(j), points.get(j+1))) {
                        return false;
//                        throw new CustomValidationException("the walls cannot intersect");
                    }
                }
            }
        }
        return true;
    }

    public boolean solvingLinearEquation(Point p1, Point p2, Point p3, Point p4){
        double [][]mat = new double[2][2];
        double [][]cons = new double[2][1];
        mat[0][0]= p2.getX() - p1.getX();
        mat[0][1]= p4.getX() - p3.getX();
        mat[1][0]= p2.getY() - p1.getY();
        mat[1][1]= p4.getY() - p3.getY();
        cons[0][0] = p3.getX()-p1.getX();
        cons[1][0] = p3.getY()-p1.getY();
        double[][] invertedMat = invertMat(mat);
        double[][] result = new double[2][1];
        for (int i = 0; i <2; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                for (int k = 0; k < 2; k++)
                {
                    result[i][j] = result[i][j] + invertedMat[i][k] * cons[k][j];
                }
            }
        }
        if((result[0][0] >= 0) && (result[1][0] <= 1)){
            return true;
        }
        else {
            return false;
        }
    }

    public double[][] invertMat(double [][]mat){
        int n = 2;
        double [][]x = new double[n][n];
        double [][]b = new double[n][n];
        int []index = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;
        gaussianMethod(mat, index);
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k] -= mat[index[j]][i]*b[index[i]][k];
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/mat[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= mat[index[j]][k]*x[k][i];
                }
                x[j][i] /= mat[index[j]][j];
            }
        }
        return x;
    }

    public void gaussianMethod(double[][] mat, int[] index) {
        int n = index.length;
        double c[] = new double[n];

        for (int i = 0; i < n; ++i)
            index[i] = i;

        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(mat[i][j]);
                if (c0 > c1)
                    c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(mat[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = mat[index[i]][j] / mat[index[j]][j];

                mat[index[i]][j] = pj;

                for (int l = j + 1; l < n; ++l)
                    mat[index[i]][l] -= pj * mat[index[j]][l];
            }
        }
    }
}
