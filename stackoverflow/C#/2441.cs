for( int i = 0; i < _numOrders; i++ )\n{\n    OrderTicket ticket = new OrderTicket(... );\n    ticket.CacheId = Guid.NewGuid();\n    Submit( ticket );  // note that this simply makes a remoting call\n}