package com.example.myapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.RequestException;

public class MyEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Element myDiv = DOM.getElementById("my_div");
        RootPanel rootPanel = RootPanel.get();
        Anchor myLink = new Anchor("Click me");
        myLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "http://www.example.com/path");
                try {
                    Request request = builder.sendRequest(null, new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            String textFromResponse = response.getText();
                            // Update your div
                            myDiv.setInnerHTML(textFromResponse);
                        }

                        @Override
                        public void onError(Request request, Throwable exception) {
                            // Handle error
                        }
                    });
                } catch (RequestException re) {
                    // Handle exception
                }
            }
        });

        rootPanel.add(myLink); // Add the link to your panel or page layout
    }

    public static void main(String[] args) {
        // Entry point for standalone application
    }
}