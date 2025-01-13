/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Main_292 {
    public static List<Element> getChildren(Element element, List<Element> list) {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        for (Element element2 : list) {
            if (element2.getParentId() != element.getId()) continue;
            arrayList.add(element2);
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        arrayList.add(new Element(1, 0));
        arrayList.add(new Element(2, 1));
        arrayList.add(new Element(3, 1));
        arrayList.add(new Element(4, 2));
        arrayList.add(new Element(5, 3));
        Element element = new Element(1, 0);
        List<Element> list = Main_292.getChildren(element, arrayList);
        System.out.println("Children of Root (" + element.getId() + "):");
        for (Element element2 : list) {
            System.out.println("Id: " + element2.getId() + ", ParentId: " + element2.getParentId());
        }
    }
}
