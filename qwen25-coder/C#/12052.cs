using (var context = new YourDbContext())\n{\n    // Assuming 'fruit' is an instance of Fruit fetched from the database\n    fruit.FruitName = "New Fruit Name";\n    fruit.FruitStatusID = newStatusId; // Set the new Status ID\n\n    context.SaveChanges();\n}