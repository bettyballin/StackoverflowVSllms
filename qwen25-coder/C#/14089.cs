// Example of using SignalR for real-time communication in ASP.NET\n   public class ChatHub : Hub\n   {\n       public void SendMessage(string name, string message)\n       {\n           Clients.All.broadcastMessage(name, message);\n       }\n   }