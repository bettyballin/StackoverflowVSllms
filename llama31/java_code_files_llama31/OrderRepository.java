/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.Persistence
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderRepository {
    private EntityManager entityManager;

    public OrderRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"your_persistence_unit_name");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Order> findAllOrders() {
        List list = this.entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        for (Order order : list) {
            order.getOrderItems().size();
        }
        return list;
    }

    public static void main(String[] stringArray) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.findAllOrders();
    }
}
