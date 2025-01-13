import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.TextSelection;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyPluginTest extends TestCase {

    private MyPlugin plugin;

    @Before
    public void setUp() throws Exception {
        plugin = new MyPlugin();
    }

    @Test
    public void testMyPlugin() {
        // Your test code goes here
    }

    public static void main(String[] args) {
    }
}