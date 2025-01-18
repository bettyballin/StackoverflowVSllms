import java.lang.String;

public class Main {

    interface Person {
        void personMethod();
    }

    interface User extends Person {
        void userMethod();
    }

    // Class to be extended sometimes in other classes and does not depend on Prospect class
    static class BasicUser implements User {
        @Override public void personMethod() {}
        @Override public void userMethod() {}
    }

    static class Prospect implements Person { // Can use extends Keyword if possible or required by the language used.
        @Override public void personMethod()  {}
    }

    // A class to have functionality of User and Prospect at specific scenarios via aggregation
    // not inheritance since it could be a one-or-many relationship, depending on requirements
    static class ProspectUser implements User { // Can use extends Keyword if possible or required by the language used.
        private Person prospect;
        private BasicUser user;

        public void setProspect(Person p) { this.prospect = p; }
        public Person getProspect() { return this.prospect; }

        // These methods could be replaced with other operations if aggregation is one-to-many.
        @Override public void userMethod() {}
        @Override public void personMethod() {}
    }
    
    public static void main(String[] args) {
    }
}