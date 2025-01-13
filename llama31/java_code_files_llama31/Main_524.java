/*
 * Decompiled with CFR 0.152.
 */
public class Main_524 {
    public static void main(String[] stringArray) {
        Child child;
        class Child
        extends Parent {
            int x = 20;

            Child() {
                class Parent {
                    int x = 10;

                    Parent() {
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
        Child child2 = child = new Child();
        System.out.println(((Parent)child2).x);
        ((Parent)child2).foo();
    }
}
