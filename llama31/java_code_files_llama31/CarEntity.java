/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.NamedQuery
 */
import javax.persistence.NamedQuery;

@NamedQuery(name="findCarsFilterByTypes", query="SELECT c FROM Car c LEFT JOIN FETCH c.owner WHERE c.type IN (:types) ORDER BY c.model")
public class CarEntity {
}
