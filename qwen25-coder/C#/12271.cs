// Example Product class\npublic class Product\n{\n    public string Code { get; set; }\n    public string Description { get; set; }\n}\n\n// In your ASPX page code-behind or wherever you're setting up the data source\nList<Product> products = new List<Product>\n{\n    new Product { Code = "A1", Description = "Product A" },\n    new Product { Code = "B2", Description = "Product B" }\n};\n\nRepeater1.DataSource = products;\nRepeater1.DataBind();