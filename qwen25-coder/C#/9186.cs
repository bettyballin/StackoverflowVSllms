var query = from table in db.Table\n            let res = (table.Distance - someValue)\n            where res < someOtherValue\n            orderby res\n            select new { Id = table.Id, Res = res };\n\n// Execute the query\nforeach (var item in query)\n{\n    Console.WriteLine($"Id: {item.Id}, Res: {item.Res}");\n}