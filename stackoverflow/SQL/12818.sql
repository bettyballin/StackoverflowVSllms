DECLARE @xml_var XML  \nSET @xml_var =  \n(\n  SELECT   *,\n    (  \n      SELECT *\n\n      FROM Orders\n\n      WHERE Orders.CustomerID=Customers.CustomerID\n\n      FOR XML AUTO, TYPE\n\n    )\n\n  FROM Customers WHERE CustomerID='ALFKI'\n\n  FOR XML AUTO, TYPE\n\n)