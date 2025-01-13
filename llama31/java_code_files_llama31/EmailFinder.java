/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.Query
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmailFinder {
    private EntityManager entityManager;
    private Object folder;

    public EmailFinder(EntityManager entityManager, Object object) {
        this.entityManager = entityManager;
        this.folder = object;
    }

    public void findEmails() {
        Query query = this.entityManager.createNamedQuery("Folder.findEmails");
        query.setParameter("folder", this.folder);
        List list = query.getResultList();
    }

    public static void main(String[] stringArray) {
    }
}
