/*
 * Decompiled with CFR 0.152.
 */
class MyActivity {
    MyActivity() {
    }

    public void setButtonClickListener() {
        RecordStartListenerImpl recordStartListenerImpl = new RecordStartListenerImpl(this);
        recordStartListenerImpl.onRecordStart();
    }

    public static void main(String[] stringArray) {
        MyActivity myActivity = new MyActivity();
        myActivity.setButtonClickListener();
    }

    private class RecordStartListenerImpl
    implements RecordStartListener {
        private RecordStartListenerImpl(MyActivity myActivity) {
        }

        @Override
        public void onRecordStart() {
            System.out.println("Record started.");
        }
    }
}
