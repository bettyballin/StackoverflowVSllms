Dim query = From f In Db.Firms\n            Group Join c In Db.Concessions On f.FirmID Equals c.FirmID Into g = Group\n            Order By g.Sum(Function(concession) concession.Area) Descending\n            Select New With {\n                .Title = f.Title,\n                .TotalArea = If(g.Any(), g.Sum(Function(concession) concession.Area), 0)\n            }\n\nFor Each result In query\n    Console.WriteLine($"Title: {result.Title}, Total Area: {result.TotalArea}")\nNext