/*
 * Decompiled with CFR 0.152.
 */
class Main_524.1Child
extends Main_524.1Parent {
    int x = 20;

    Main_524.1Child() {
        class Parent {
            int x;

            Parent() {
                this.x = 10;
            }

            void foo() {
                System.out.println("Parent.foo");
            }
        }
    }

    @Override
    void foo() {
        System.out.println("Child.foo");
    }
}
