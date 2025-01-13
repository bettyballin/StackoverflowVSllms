/*
 * Decompiled with CFR 0.152.
 */
static class DataCache.1
implements AsyncCallback<String> {
    DataCache.1() {
    }

    @Override
    public void onSuccess(String string) {
        System.out.println("Retrieved data: " + string);
    }
}
