/*
 * Decompiled with CFR 0.152.
 */
class Engine {
    private String type;

    public Engine(String string) {
        this.type = string;
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Engine engine = (Engine)object;
        return this.type.equals(engine.type);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "Engine{type='" + this.type + "'}";
    }
}
