SELECT TOP 1\n  ordid\nFROM\n  orders\nWHERE\n  custid = @custid\n  and datesold < (SELECT MAX(datesold) FROM orders i where i.custid = orders.custid)\nORDER BY\n  datesold DESC