import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.jxpath.JXPathContext;

public class Animal {
    private UUID uuid;
    private int numLegs;
    private AnimalType type;

    public enum AnimalType {
        CHICKEN, FROG, DOG, CAT
    }

    public Animal(AnimalType type) {
        this.type = type;
        uuid = UUID.randomUUID();
        switch (type) {
            case CHICKEN:
                numLegs = 2;
                break;
            case FROG:
                numLegs = 2;
                break;
            case DOG:
                numLegs = 4;
                break;
            case CAT:
                numLegs = 4;
                break;
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public String toString(){
        return "UUID: "+uuid+", Animal: "+type+ ", Legs: "+numLegs;
    }

    private static List<Animal> getAnimals(int numAnimals) {
        ArrayList<Animal> animals = new ArrayList<>();
        for(int i = 0; i<numAnimals; i++){
            if(i%4==0){
                animals.add(new Animal(AnimalType.CAT));
            }
            else if(i%3==0){
                animals.add(new Animal(AnimalType.DOG));
            }
            else if(i%2==0){
                animals.add(new Animal(AnimalType.FROG));
            }
            else{
                animals.add(new Animal(AnimalType.CHICKEN));
            }
        }
        return animals;
    }

    public static void main(String[] args){
        List<Animal> animals = getAnimals(10000);
        JXPathContext animsContext = JXPathContext.newContext(animals);

        // Query for all Animals where type='CAT'
        Iterator catsIter = animsContext.iteratePointers(".[type='CAT']");
        
        List<Animal> cats = new ArrayList<>();
        while(catsIter.hasNext()){
            cats.add((Animal) ((org.apache.commons.jxpath.Pointer)catsIter.next()).getValue());
        }
        System.out.println("Number of Cats is: "+cats.size());

        // Query for all Animals where numLegs=4
        Iterator legsFourIter = animsContext.iteratePointers(".[numLegs=4]");
        
        List<Animal> fourLeggedAnimals = new ArrayList<>();
        while(legsFourIter.hasNext()){
            fourLeggedAnimals.add((Animal) ((org.apache.commons.jxpath.Pointer)legsFourIter.next()).getValue());
        }
        System.out.println("Number of Animals with 4 legs is: " + fourLeggedAnimals.size());
    }
}