public class TicketHub : Hub\n{\n    public void StartEditing(int ticketId)\n    {\n        Clients.Others.TicketIsBeingEdited(ticketId);\n    }\n}