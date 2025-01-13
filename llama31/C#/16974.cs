// Using a projection to retrieve only needed columns\nvar myThings = dbContext.MyThings\n    .Select(mt => new MyThingDTO { A = mt.A, B = mt.B })\n    .ToList();\n\n// Using lazy loading to retrieve additional columns only when needed\nvar myThing = dbContext.MyThings.Find(1);\nif (myThing != null)\n{\n    // Load additional columns only when needed\n    dbContext.Entry(myThing).Reference("C").Load();\n    dbContext.Entry(myThing).Reference("D").Load();\n}