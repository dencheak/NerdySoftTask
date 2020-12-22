package denis.lishchuk.java_test.dto.response;

public class ErrorResponse {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorResponse(String error) {
        this.error = error;
    }
}
