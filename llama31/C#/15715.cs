using Microsoft.AspNetCore.SignalR;\n\npublic class TicketHub : Hub\n{\n    public async Task StartEditing(int ticketId)\n    {\n        await Clients.OthersInGroup(ticketId.ToString()).SendAsync("Someone else is editing this ticket");\n    }\n}