import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrolledComposite;
import org.eclipse.swt.graphics.Point;

public class ScrollableCompositeWidget {
    private Composite mParent;

    public void createPartControl(Composite parent) {
        parent.setLayout(new FillLayout());
        ScrolledComposite scrollBox = new ScrolledComposite(parent, SWT.V_SCROLL);
        scrollBox.setExpandHorizontal(true);
        mParent = new Composite(scrollBox, SWT.NONE);
        scrollBox.setContent(mParent);
        FormLayout layout = new FormLayout();
        mParent.setLayout(layout);
        // Adds a bunch of controls here
        
        // Calculate and set the minimum size of the content composite
        Point minSize = mParent.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
        mParent.setSize(minSize);
        
        // Set the scrolled composite's min size to match the content
        scrollBox.setMinSize(minSize);
    }

    public static void main(String[] args) {
    }
}