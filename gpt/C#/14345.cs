using (var context = new YourDbContext())\n{\n    var fruit = context.Fruits.FirstOrDefault(f => f.FruitID == someFruitID);\n\n    if (fruit != null)\n    {\n        fruit.FruitName = "NewFruitName";\n        fruit.FruitStatusID = newStatusID; // newStatusID should be the ID of the new status\n\n        context.SaveChanges();\n    }\n}