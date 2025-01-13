/*
 * Decompiled with CFR 0.152.
 */
public class BlockExecutor {
    public static void respondTo(Block block) {
        block.execute(new Format());
    }

    public static void main(String[] stringArray) {
        BlockExecutor.respondTo(new Block(){

            @Override
            public void execute(Format format) {
            }
        });
    }
}
