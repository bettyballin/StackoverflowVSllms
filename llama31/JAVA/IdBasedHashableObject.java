public class IdBasedHashableObject {
    private long id;

    public IdBasedHashableObject(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return (int) id; // assuming 'id' is a unique identifier
    }

    public static void main(String[] args) {
        IdBasedHashableObject obj = new IdBasedHashableObject(123L);
        System.out.println(obj.hashCode());
    }
}