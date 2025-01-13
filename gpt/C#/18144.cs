for(int i = 0; i < _numOrders; i++)\n{\n    OrderTicket ticket = new OrderTicket(...);\n    Guid newGuid = Guid.NewGuid();\n    Console.WriteLine($"Generated Guid: {newGuid}");\n    ticket.CacheId = newGuid;\n    Console.WriteLine($"Ticket CacheId: {ticket.CacheId}");\n    Submit(ticket);  // note that this simply makes a remoting call\n}