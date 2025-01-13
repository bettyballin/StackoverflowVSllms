import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class User {
    String name;
    List<User> friends;

    public User(String name) {
        this.name = name;
        friends = new ArrayList<>();
    }
}

public class Main_514_514 {
    public static void main(String[] args) {
        // Create users and add friends
        User userA = new User("A");
        User userB = new User("B");
        User userC = new User("C");
        User userD = new User("D");
        User userE = new User("E");

        userA.friends.add(userB);
        userB.friends.add(userC);
        userC.friends.add(userD);
        userD.friends.add(userE);

        // Perform BFS to find the degree of separation
        int degree = bfs(userA, userE);
        if (degree != -1) {
            System.out.println("Degree of separation: " + degree);
        } else {
            System.out.println("Users are not connected");
        }
    }

    public static int bfs(User start, User target) {
        Queue<User> queue = new LinkedList<>();
        Set<User> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        int degree = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                User currentUser = queue.poll();
                if (currentUser == target) {
                    return degree;
                }
                for (User friend : currentUser.friends) {
                    if (!visited.contains(friend)) {
                        queue.offer(friend);
                        visited.add(friend);
                    }
                }
            }
            degree++;
        }
        return -1;
    }
}