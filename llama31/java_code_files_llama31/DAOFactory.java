/*
 * Decompiled with CFR 0.152.
 */
class DAOFactory {
    DAOFactory() {
    }

    public static MyDAO createDAO(Request request) {
        return new MyDAO(){

            @Override
            public void doSomething() {
                System.out.println("Doing something with the DAO instance");
            }
        };
    }
}
