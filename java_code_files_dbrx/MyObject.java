import java.lang.String;
public class MyObject {
    private Object paramA; // Initialize this properly based on your use-case
    private Object paramB; // and make sure it is clear about its purpose in comments or documentation
    private Object paramC;
    private Object paramD = new Object();  // Immutable field. Once assigned, can't be changed (depending language)

//... Code here ..

private void start() {
   // manipulate this.paramA, this.paramB and other fields as needed
}

private void process() {
    // ... use or modify this.paramD in some way without changing the reference itself....
}

private void stop() {
    // manipute this.paramC here... Note that order of function execution is not relied upon!
}  
	public static void main(String[] args) {
	}
}