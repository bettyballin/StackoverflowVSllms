import java.lang.String;

public class ContractActionHandle {
    public interface ContactHandle {
        Result execute() throws ContractError;
        void requirePreconditions() throws PreconditionException;
        void ensurePostConditions(Result result) throws PostConditionException;
    }
    public static void main(String[] args) {
    }
}

class Result {
}

class ContractError extends Exception {
}

class PreconditionException extends Exception {
}

class PostConditionException extends Exception {
}