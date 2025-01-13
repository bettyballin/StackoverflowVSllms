/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.NamedQuery
 */
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findMyEntityByWord", query="SELECT m FROM MyEntity m WHERE m.normalizedWord LIKE :word")
public class MyEntity_1 {
}
