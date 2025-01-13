using (var dbContext = new MyDbContext()) {\n    var results = from c in dbContext.Customers\n                  where c.Age > 30\n                  select c;\n\n    foreach (var customer in results) {\n        Console.WriteLine(customer.Name);\n    }\n}