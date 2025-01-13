var query = db.Customers\n                 .Where(c => c.City == "London")\n                 .Select(c => c);\n\n   foreach (var cust in query)\n   {\n       Console.WriteLine("id = {0}, City = {1}", cust.CustomerID, cust.City);\n   }