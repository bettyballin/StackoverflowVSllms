using Microsoft.AspNet.SignalR;\n\n    public class ChatHub : Hub\n    {\n        public void Send(string message)\n        {\n            // Call the broadcastMessage method to update clients.\n            Clients.All.broadcastMessage(message);\n        }\n    }