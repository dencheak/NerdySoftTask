package denis.lishchuk.java_test.exception;

public class CustomValidationException extends RuntimeException{

    public CustomValidationException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


}
