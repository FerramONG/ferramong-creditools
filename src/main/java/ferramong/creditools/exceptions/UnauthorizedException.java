package ferramong.creditools.exceptions;

public class UnauthorizedException extends Exception {

    public UnauthorizedException() {
        super("Unauthorized access");
    }
}
