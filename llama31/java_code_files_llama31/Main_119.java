/*
 * Decompiled with CFR 0.152.
 */
public class Main_119 {
    public static void main(String[] stringArray) {
        MagicalManyToOneMap<Location, Region> magicalManyToOneMap = new MagicalManyToOneMap<Location, Region>();
        Location location = Game.chooseSomeLocation();
        Region region = new Region("Mine");
        magicalManyToOneMap.put(location, region);
        Region region2 = Game.getSomeOtherRegion();
        magicalManyToOneMap.put(location, region2);
        for (Location location2 : magicalManyToOneMap.getInverse(region)) {
            System.out.println("Location: " + String.valueOf(location2));
        }
    }
}
