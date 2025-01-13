/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;

public class AnimalFilter {
    public static void main(String[] stringArray) {
        AnimalContext animalContext = new AnimalContext();
        Iterator<Animal> iterator = animalContext.iterate("/.[type='CAT']");
        ArrayList<Animal> arrayList = new ArrayList<Animal>();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
    }
}
