/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 */
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="link_table")
public class LinkTable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID linkId;
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Parent parent;
    @ManyToOne
    @JoinColumn(name="child_id")
    private Child child;

    public UUID getLinkId() {
        return this.linkId;
    }

    public void setLinkId(UUID uUID) {
        this.linkId = uUID;
    }

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return this.child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public static void main(String[] stringArray) {
    }
}
