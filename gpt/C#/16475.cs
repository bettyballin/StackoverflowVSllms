using (var unitOfWork = new UnitOfWork(new DataContext()))\n{\n    var product = new Product { Name = "New Product", Category = "Category1" };\n    unitOfWork.Products.Add(product);\n    unitOfWork.Commit();\n}