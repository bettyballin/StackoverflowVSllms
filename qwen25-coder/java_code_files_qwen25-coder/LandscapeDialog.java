public class LandscapeDialog extends Dialog {

    public LandscapeDialog(Context context) {
        super(context, R.style.FullScreenDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
    }

    public static void main(String[] args) {
    }
}

class Dialog {
    public Dialog(Context context, int themeResId) {
    }

    protected void onCreate(Bundle savedInstanceState) {
    }

    protected void setContentView(int layoutResID) {
    }
}

class Context {
}

class Bundle {
}

class R {
    public static class style {
        public static final int FullScreenDialog = 1;
    }
    public static class layout {
        public static final int dialog_layout = 2;
    }
}