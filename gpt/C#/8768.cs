using (var context = new ApplicationDbContext())\n{\n    // Create\n    var product = new Product { Name = "Laptop", Price = 999.99m };\n    context.Products.Add(product);\n    context.SaveChanges();\n\n    // Read\n    var products = context.Products\n                          .Where(p => p.Price > 500)\n                          .ToList();\n\n    // Update\n    var existingProduct = context.Products.FirstOrDefault(p => p.ProductId == product.ProductId);\n    if (existingProduct != null)\n    {\n        existingProduct.Price = 899.99m;\n        context.SaveChanges();\n    }\n\n    // Delete\n    var productToDelete = context.Products.FirstOrDefault(p => p.ProductId == product.ProductId);\n    if (productToDelete != null)\n    {\n        context.Products.Remove(productToDelete);\n        context.SaveChanges();\n    }\n}