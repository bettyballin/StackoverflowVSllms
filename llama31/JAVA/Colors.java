import java.util.ArrayList;
import java.util.List;

public class Colors {
    private List<String> colors = new ArrayList<>();

    public void addColor(String color) {
        colors.add(color);
    }

    public List<String> getColors() {
        return colors;
    }

    public static void main(String[] args) {
        Colors colors = new Colors();
        colors.addColor("Red");
        colors.addColor("Green");
        colors.addColor("Blue");
        System.out.println(colors.getColors());
    }
}