import java.io.Serializable;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Entity {
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface EmbeddedId {
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ManyToOne {
}

@Entity
public class Role {
    @EmbeddedId
    private RoleId id;

    // other properties and methods

    public static class RoleId implements Serializable {
        @ManyToOne
        private Actor actor;

        @ManyToOne
        private Movie movie;

        @ManyToOne
        private Character character;

        // getters, setters, equals(), hashCode()
    }

    public static void main(String[] args) {
    }
}

class Actor {
}

class Movie {
}

class Character {
}