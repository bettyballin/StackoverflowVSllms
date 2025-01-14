package com.example.myplugin.tests;

public class ExampleTest_1 {

    @Test
    public void testMyPluginInitialization() {
        // Replace 'com.example.myplugin' with your plugin's ID.
        Plugin plugin = AbstractUIPlugin.find(Activator.PLUGIN_ID);
        Assert.assertTrue("Plug-in should be initialized", plugin != null && plugin.isBundleActive());
    }

    public static void main(String[] args) {
    }
}

// Define the Plugin class
class Plugin {
    public boolean isBundleActive() {
        return true;
    }
}

// Define the AbstractUIPlugin class
class AbstractUIPlugin {
    public static Plugin find(String id) {
        return new Plugin();
    }
}

// Define the Activator class
class Activator {
    public static final String PLUGIN_ID = "com.example.myplugin";
}

// Define the Assert class
class Assert {
    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}

// Define the Test annotation
@interface Test {
}