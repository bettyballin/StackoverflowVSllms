/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/students"})
public class StudentController {
    @GetMapping(value={"/{id}"})
    public Student getStudent(@PathVariable Long l) {
        return null;
    }

    @GetMapping
    public List<Student> getStudents() {
        return null;
    }

    public static void main(String[] stringArray) {
    }
}
