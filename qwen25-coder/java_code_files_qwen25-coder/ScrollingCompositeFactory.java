import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ScrollingCompositeFactory {
    public void createPartControl(Composite parent) {
        parent.setLayout(new FillLayout());
        ScrolledComposite scrollBox = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
        // Enable autoscrolling and always show scrollbars when needed
        scrollBox.setExpandHorizontal(true);
        scrollBox.setExpandVertical(true);

        Composite contentComp = new Composite(scrollBox, SWT.NONE);
        FormLayout layout = new FormLayout();
        contentComp.setLayout(layout);

        // Adds a bunch of controls here

        // Set the size of the container to fit its contents
        contentComp.setSize(contentComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        // Set the content and make sure that the ScrolledComposite can scroll based on content size
        scrollBox.setContent(contentComp);
        scrollBox.setMinSize(contentComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        // Make sure to refresh layout
        scrollBox.layout();
    }

    public static void main(String[] args) {
    }
}