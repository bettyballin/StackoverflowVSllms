var user = dbContext.Users.FirstOrDefault(u => u.Id == someId);\n\nif (user.EmailAddress == null)\n{\n    // This will cover both managed null and database NULL.\n}