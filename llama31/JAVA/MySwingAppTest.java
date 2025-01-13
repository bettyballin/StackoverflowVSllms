import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JPanelFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.JUnit4;

import javax.swing.*;

public class MySwingAppTest {
    @Test
    public void testLoginButton() {
        // Launch the application
        FrameFixture frame = new FrameFixture(new MySwingApp());

        // Find the login button
        JPanelFixture panel = frame.panel("loginPanel");
        JButtonFixture loginButton = panel.button("loginButton");

        // Simulate a click on the login button
        loginButton.click();

        // Verify the expected result
        JLabelFixture loginResultLabel = frame.label("loginResult");
        loginResultLabel.requireText("Login successful");
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MySwingAppTest");
    }
}