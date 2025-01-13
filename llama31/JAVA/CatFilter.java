import java.util.List;
import java.util.stream.Collectors;

public class CatFilter {
    public static void main(String[] args) {
        // Define the Cat class
        class Cat {
            private String birthday;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }
        }

        // Define the target birthday
        String targetBirthday = "some date";

        // Define the list of cats
        List<Cat> cats = List.of(
            new Cat() {{ setBirthday("some date"); }},
            new Cat() {{ setBirthday("other date"); }}
        );

        // Filter the cats
        List<Cat> catsBornOnTargetBirthday = cats.stream()
            .filter(cat -> cat.getBirthday().equals(targetBirthday))
            .collect(Collectors.toList());

        // Print the result
        System.out.println(catsBornOnTargetBirthday.size());
    }
}