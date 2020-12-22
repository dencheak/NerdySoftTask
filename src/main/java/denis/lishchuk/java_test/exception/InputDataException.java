package denis.lishchuk.java_test.exception;

public class InputDataException extends RuntimeException {
    public InputDataException() {
    }

    public InputDataException(String message) {
        super(message);
    }
}

