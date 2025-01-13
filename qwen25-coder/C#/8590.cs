using System;\nusing System.Data.Entity;\n\npublic class MyDbContext : DbContext\n{\n    public DbSet<Employee> Employees { get; set; }\n}\n\npublic class Employee\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    public string Position { get; set; }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        using (var context = new MyDbContext())\n        {\n            // Add a new employee\n            var emp = new Employee { Name = "John Doe", Position = "Developer" };\n            context.Employees.Add(emp);\n            context.SaveChanges();\n\n            // Query employees\n            var employees = context.Employees.ToList();\n            foreach (var e in employees)\n            {\n                Console.WriteLine($"ID: {e.Id}, Name: {e.Name}, Position: {e.Position}");\n            }\n        }\n    }\n}