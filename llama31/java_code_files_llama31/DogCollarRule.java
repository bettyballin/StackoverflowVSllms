/*
 * Decompiled with CFR 0.152.
 */
class DogCollarRule
implements Rule {
    DogCollarRule() {
    }

    public void evaluate(Context context) {
        if (context.getDog().hasCollar()) {
            System.out.println("The dog " + context.getDog().getName() + " has a collar.");
        } else {
            System.out.println("The dog " + context.getDog().getName() + " does not have a collar.");
        }
    }
}
