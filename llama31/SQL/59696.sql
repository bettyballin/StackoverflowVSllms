SELECT \n    od.TotalPrice,\n    it.GLacct\nFROM \n    (\n        SELECT \n            orderID,\n            itemID,\n            SUM(Price * quantity) AS TotalPrice\n        FROM \n            OrderDetail_table\n        GROUP BY \n            orderID, itemID\n    ) od\n    LEFT OUTER JOIN order_table ot ON od.orderID = ot.orderid\n    LEFT OUTER JOIN item_table it ON od.itemID = it.itemID\nWHERE \n    ot.invoiceDate = #01/31/2009#