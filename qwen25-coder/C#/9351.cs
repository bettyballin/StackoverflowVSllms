using Microsoft.AspNetCore.SignalR;\n\npublic class ChatHub : Hub\n{\n    public async Task SendMessage(string user, string message)\n    {\n        await Clients.All.SendAsync("ReceiveMessage", user, message);\n    }\n}