/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.TextView
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloWorld_18
extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)"Hello, World!");
        this.setContentView((View)textView);
    }

    public static void main(String[] stringArray) {
    }
}
