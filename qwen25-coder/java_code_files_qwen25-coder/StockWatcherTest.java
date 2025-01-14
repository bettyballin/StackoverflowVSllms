package com.google.gwt.sample.stockwatcher.client;

import java.util.Set;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class StockWatcherTest extends GWTTestCase {

    public String getModuleName() {
        return "com.google.gwt.sample.stockwatcher.StockWatcher";
    }

    @Override
    protected void setUp() throws Exception {
        // Set the module base URL explicitly
        GWT.setModuleBaseURL(GWT.getHostPageBaseURL() + "stockwatcher/");
        super.setUp();
    }

    public void testSimple() {
        GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
        greetingService.greetServer("Bob", new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught);
                fail("big time failure");
                finishTest();
            }

            @Override
            public void onSuccess(String result) {
                System.out.println("success, biatch");
                assertTrue(true);
                finishTest();  // Don't forget to call this in the success case
            }
        });
        delayTestFinish(1000); // Ensure your test doesn't timeout
    }

    public static void main(String[] args) {
    }
}