using System.Linq;\nusing Telerik.OpenAccess;\n\npublic class DataAccessExample\n{\n    public void QueryDatabase()\n    {\n        using (var context = new EntitiesModel())\n        {\n            var employees = from emp in context.Employees\n                            where emp.Department == "Engineering"\n                            select emp;\n            \n            foreach (var employee in employees)\n            {\n                Console.WriteLine($"Employee: {employee.Name}, Department: {employee.Department}");\n            }\n        }\n    }\n}