/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class ObjectFilter {
    public static void main(String[] stringArray) {
        List<3> list = List.of(new MyObject(){
            {
                this.setSomeProperty(1);
            }
        }, new MyObject(){
            {
                this.setSomeProperty(2);
            }
        }, new MyObject(){
            {
                this.setSomeProperty(1);
            }
        });
        int n = 1;
        List list2 = list.stream().filter(myObject -> myObject.getSomeProperty() == n).collect(Collectors.toList());
        System.out.println(list2.size());
    }
}
