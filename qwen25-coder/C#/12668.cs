for( int i = 0; i < _numOrders; i++ )\n{\n    OrderTicket ticket = new OrderTicket(... ); // create new instance here\n    ticket.CacheId = Guid.NewGuid();\n    Submit( ticket );  \n}