import java.util.ArrayList;
import java.util.List;

public class MyBean_2 {
    private List<String> someList;

    public MyBean() {
        this.someList = new ArrayList<>();
    }

    public void addToSomeList(String item) {
        this.someList.add(item);
    }

    public int getSomeListSize() {
        return this.someList.size();
    }

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        myBean.addToSomeList("Item1");
        myBean.addToSomeList("Item2");
        System.out.println("Size of someList: " + myBean.getSomeListSize());
    }
}