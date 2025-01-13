/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class CatFilter {
    public static void main(String[] stringArray) {
        String string = "some date";
        class Cat {
            private String birthday;

            Cat() {
            }

            public String getBirthday() {
                return this.birthday;
            }

            public void setBirthday(String string) {
                this.birthday = string;
            }
        }
        List<2> list = List.of(new Cat(){
            {
                this.setBirthday("some date");
            }
        }, new Cat(){
            {
                this.setBirthday("other date");
            }
        });
        List list2 = list.stream().filter(cat -> cat.getBirthday().equals(string)).collect(Collectors.toList());
        System.out.println(list2.size());
    }
}
