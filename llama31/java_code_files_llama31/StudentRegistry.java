/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<Integer, Student> studentList = new HashMap<Integer, Student>();

    public void removeStudent(int n) throws RemoteException, StudentNotFoundException {
        Student student = this.studentList.remove(n);
        if (student == null) {
            throw new StudentNotFoundException("Student with id:" + n + " not found in the system");
        }
    }

    public static void main(String[] stringArray) {
    }
}
