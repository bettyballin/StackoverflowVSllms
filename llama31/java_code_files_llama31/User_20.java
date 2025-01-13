/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.NamedQueries
 *  javax.persistence.NamedQuery
 */
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value={@NamedQuery(name="User.findByUsername", query="SELECT u FROM User u WHERE u.username = :username")})
public class User_20 {
}
