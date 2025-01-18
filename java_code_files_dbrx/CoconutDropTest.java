public class CoconutDropTest {
    int M = 100; // total floors in building
    int start = 1; // first floor
    int end = M; // last floor
    boolean broken[] = new boolean[M];

    public void throwCoconutFromFloor(int floor) {
        // simulate throwing coconut from floor
        // implementation goes here
    }

    public void runTest() {
        while(start <= end){
            int mid = start + (end - start)/2; // middle point of current search range
            if(!broken[mid - 1]){ // if coconut is not broken till floor-1
                throwCoconutFromFloor(mid); // simulate throwing coconut from floor mid
            } else {
                end = mid - 1; // if it breaks, go left in the search space
            }
        }
    }

    public static void main(String[] args) {
        CoconutDropTest test = new CoconutDropTest();
        test.runTest();
    }
}