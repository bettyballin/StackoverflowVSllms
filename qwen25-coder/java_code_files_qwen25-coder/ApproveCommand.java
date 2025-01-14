public class CommandPatternExample {
    interface Command {
        void execute();
    }

    class ApproveCommand implements Command {
        private Request request;

        public ApproveCommand(Request request) { 
            this.request = request; 
        }

        public void execute() { 
            request.approve(); 
        }
    }

    // Implement other commands similarly (DisapproveCommand, etc.)

    public static void main(String[] args) {
    }
}

class Request {
    public void approve() {
        // Implementation here
    }
}