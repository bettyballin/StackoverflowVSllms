import java.lang.String;

public class ContractHandlerT {
    public interface IContractHandler<T> {
        /**
         * Execute contract will invoke the #invokeContract method.
         * Precondition and postconditions checks are part of this method.
         *
         * @param input - Precondition Input Data, can be null if applicable.
         * @return Post condition output
         * @throws ContractError if precondition is not met or postcondition fails
         */
        public T executeContract(final T input) throws ContractError;

        /**
         * Require that the preconditions are met. This method will throw a ContractError if the precondition is violated.
         *
         * @param input - Input data for checking the precondition
         * @throws ContractError if precondition is not met.
         */
        public void require(final T input) throws ContractError;

        /**
         * Ensure that the postconditions are met. This method will throw a ContractError if the postcondition is violated.
         *
         * @param result - Result data from invokeContract for checking the postcondition
         * @throws ContractError if postcondition is not met.
         */
        public void ensure(final T result) throws ContractError;

        /**
         * The actual method that performs the operation once preconditions are checked.
         * Postcondition checks can use returned value of this method.
         *
         * @param input - Precondition Input Data, can be null if applicable.
         * @return Result after performing the contract operation
         */
        public T invokeContract(final T input) throws ContractError;
    }

    public static void main(String[] args) {
    }

    public static class ContractError extends Exception {
        public ContractError(String message) {
            super(message);
        }
    }
}