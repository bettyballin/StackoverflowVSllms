SELECT \n    SUM(od.Price * od.quantity) AS totalPrice,\n    it.GLacct\nFROM \n    OrderDetail_table od\n    LEFT OUTER JOIN order_table ot ON od.orderID = ot.orderid\n    LEFT OUTER JOIN item_table it ON od.itemID = it.itemID\nWHERE \n    ot.invoiceDate = #01/31/2009#\nGROUP BY \n    it.GLacct