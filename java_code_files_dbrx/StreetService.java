public class StreetService {
    public StreetService() {
        Street street = new Street();
        street.setName("default name"); // for example
        entityManager.persist(street);
    }

    public static void main(String[] args) {
    }
}