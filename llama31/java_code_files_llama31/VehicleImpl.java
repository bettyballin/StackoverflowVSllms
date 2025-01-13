/*
 * Decompiled with CFR 0.152.
 */
public class VehicleImpl
implements Vehicle {
    private final Engine engine;

    public VehicleImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        VehicleImpl vehicleImpl = (VehicleImpl)object;
        return this.engine.equals(vehicleImpl.engine);
    }

    public int hashCode() {
        return this.engine.hashCode();
    }

    public String toString() {
        return "VehicleImpl{engine=" + String.valueOf(this.engine) + "}";
    }

    public static void main(String[] stringArray) {
        Engine engine = new Engine("V8");
        VehicleImpl vehicleImpl = new VehicleImpl(engine);
        System.out.println(vehicleImpl.toString());
    }
}
