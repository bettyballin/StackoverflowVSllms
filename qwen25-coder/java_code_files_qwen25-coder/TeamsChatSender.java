// Example of using Microsoft Graph SDK for Java to send chat message
package com.example.teamschat;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.models.BodyType;
import com.microsoft.graph.models.ChatMessage;
import com.microsoft.graph.models.ItemBody;
import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.httpcore.HttpClients;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class TeamsChatSender {
    public static void main(String[] args) {
        IAuthenticationProvider authProvider = request -> {
            // Add your authentication logic here to get the access token
            request.addHeader("Authorization", "Bearer " + getAccessToken());
        };

        DefaultLogger logger = new DefaultLogger();
        logger.setLoggingLevel(LoggerLevel.DEBUG);

        OkHttpClient httpClient = HttpClients.createDefault();

        GraphServiceClient<Request> graphClient = GraphServiceClient.builder()
                .authenticationProvider(authProvider)
                .httpClient(httpClient)
                .logger(logger)
                .buildClient();

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.body = new ItemBody();
        chatMessage.body.contentType = BodyType.TEXT;
        chatMessage.body.content = "Hello via Graph API!";

        try {
            graphClient.teams("{team-id}").channels("{channel-id}")
                    .messages()
                    .buildRequest()
                    .post(chatMessage);
        } catch (final ClientException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getAccessToken() {
        // Placeholder method to obtain an OAuth access token
        return "your-access-token-here";
    }
}