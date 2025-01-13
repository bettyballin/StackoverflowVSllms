SELECT \n  s.name, \n  SUM(shp.issuedOrders) AS totalIssuedOrders, \n  SUM(shp.salesRevenue) AS totalSalesRevenue, \n  SUM(shp.callsInBound) AS totalCallsInbound, \n  SUM(shp.callsOutBound) AS totalCallsOutbound\nFROM \n  salesperson s\n  JOIN (\n    SELECT \n      salesPersonId, \n      timestamp, \n      issuedOrders, \n      salesRevenue, \n      callsInBound, \n      callsOutBound, \n      ROW_NUMBER() OVER (PARTITION BY salesPersonId, DATE(timestamp) ORDER BY timestamp DESC) AS row_num\n    FROM \n      salesperson_hourly_performance\n  ) shp ON s.id = shp.salesPersonId\nWHERE \n  shp.row_num = 1\n  AND shp.timestamp BETWEEN '2009-05-03 00:00:00' AND '2009-05-04 00:00:00'\nGROUP BY \n  s.name\nORDER BY \n  totalSalesRevenue DESC;