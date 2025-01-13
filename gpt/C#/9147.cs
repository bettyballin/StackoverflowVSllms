using System;\nusing System.Linq;\nusing System.Data.Entity;\n\npublic class Product\n{\n    public int ProductId { get; set; }\n    public string Name { get; set; }\n}\n\npublic class ProductContext : DbContext\n{\n    public DbSet<Product> Products { get; set; }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        using (var context = new ProductContext())\n        {\n            var product = new Product { Name = "Sample Product" };\n            context.Products.Add(product);\n            context.SaveChanges();\n\n            var query = from p in context.Products\n                        orderby p.Name\n                        select p;\n\n            foreach (var item in query)\n            {\n                Console.WriteLine(item.Name);\n            }\n        }\n    }\n}