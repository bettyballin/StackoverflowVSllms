import java.util.*;

class Cat {
    private Date birthday;

    public Cat(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }
}

public class Main_61 {
    public static void main(String[] args) {
        // Define the sorted list of cats
        List<Cat> cats = new ArrayList<>();
        // Add some cat instances to the list for demonstration
        cats.add(new Cat(new Date(82, 0, 1)));
        cats.add(new Cat(new Date(83, 0, 24)));
        cats.add(new Cat(new Date(83, 0, 24)));
        cats.add(new Cat(new Date(84, 0, 1)));

        // Sort the list of cats by birthday
        Collections.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getBirthday().compareTo(cat2.getBirthday());
            }
        });

        // Define the target birthday
        Date targetBirthday = new Date(83, 0, 24); // January 24th, 1983

        // Find the first cat born on the target birthday
        int firstIndex = Collections.binarySearch(cats, new Cat(targetBirthday), new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getBirthday().compareTo(cat2.getBirthday());
            }
        });

        // If no cat is found, firstIndex will be negative
        if (firstIndex >= 0) {
            // Find the last cat born on the target birthday
            int lastIndex = firstIndex;
            while (lastIndex + 1 < cats.size() && cats.get(lastIndex + 1).getBirthday().equals(targetBirthday)) {
                lastIndex++;
            }

            // Get all cats born on the target birthday
            List<Cat> catsBornOnTargetBirthday = cats.subList(firstIndex, lastIndex + 1);
            System.out.println("Cats born on target birthday: " + catsBornOnTargetBirthday.size());
        } else {
            System.out.println("No cats born on target birthday");
        }
    }
}