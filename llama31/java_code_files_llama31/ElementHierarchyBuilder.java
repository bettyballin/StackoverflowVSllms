/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ElementHierarchyBuilder {
    public List<Element> getChildren(Element element, List<Element> list) {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        for (Element element2 : list) {
            if (element2.getParent() != element.getId()) continue;
            arrayList.add(element2);
            arrayList.addAll(this.getChildren(element2, list));
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ElementHierarchyBuilder elementHierarchyBuilder = new ElementHierarchyBuilder();
        ArrayList<Element> arrayList = new ArrayList<Element>();
        arrayList.add(new Element(1, 0));
        arrayList.add(new Element(2, 1));
        arrayList.add(new Element(3, 1));
        arrayList.add(new Element(4, 2));
        arrayList.add(new Element(5, 3));
        Element element = (Element)arrayList.get(0);
        List<Element> list = elementHierarchyBuilder.getChildren(element, arrayList);
        System.out.println("Children of root element:");
        for (Element element2 : list) {
            System.out.println(element2.getId());
        }
    }
}
