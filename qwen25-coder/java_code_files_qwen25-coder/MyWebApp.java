package com.example.myapp.client;

import java.lang.String;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyWebApp implements EntryPoint {

    public void onModuleLoad() {
        Button button = new Button("Click Me!");
        button.addClickHandler(event -> Window.alert("Button Clicked!"));
        RootPanel.get().add(button);
    }

    public static void main(String[] args) {
    }
}