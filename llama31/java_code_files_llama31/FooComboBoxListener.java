/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class FooComboBoxListener {
    public FooComboBoxListener() {
        JComboBox jComboBox = new JComboBox();
        jComboBox.addItemListener(new ItemListener(this){

            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == 2) {
                    Object object = itemEvent.getItem();
                } else if (itemEvent.getStateChange() == 1) {
                    Object object = itemEvent.getItem();
                }
            }
        });
    }

    public static void main(String[] stringArray) {
        new FooComboBoxListener();
    }
}
