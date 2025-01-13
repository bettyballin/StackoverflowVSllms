public class CatalogItem\n{\n    public int Id { get; private set; }\n    public string Name { get; private set; }\n    public decimal Price { get; private set; }\n\n    public CatalogItem(int id, string name, decimal price)\n    {\n        Id = id;\n        Name = name;\n        Price = price;\n    }\n\n    // Additional business logic and methods\n}