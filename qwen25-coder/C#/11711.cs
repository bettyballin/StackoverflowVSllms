var topOrders = db.Orders.OrderByDescending(o => o.totalOrder).Take(5);