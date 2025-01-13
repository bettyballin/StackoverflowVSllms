import java.lang.String;

public interface IError {
    void setErrorCode(int code);
}

public class Error implements IError {
    private int code;

    @Override
    public void setErrorCode(int code) {
        this.code = code;
    }

    public int getErrorCode() {
        return code;
    }
}

public interface IError2 {
    int getErrorCode();
}

public class Error2 implements IError2 {
    private int code;

    public void setErrorCode(int code) {
        this.code = code;
    }

    @Override
    public int getErrorCode() {
        return code;
    }

    public static void main(String[] args) {
    }
}