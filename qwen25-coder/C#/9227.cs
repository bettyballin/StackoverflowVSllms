// Example of leveraging a simple abstraction in C# for data access\nusing (var context = new MyDbContext())\n{\n    var result = context.Users.Where(u => u.IsActive).ToList();\n}