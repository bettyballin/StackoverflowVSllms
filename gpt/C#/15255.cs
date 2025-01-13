using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class OrderLine\n{\n    public Product Product { get; set; }\n}\n\npublic class Product\n{\n    public string Name { get; set; }\n    public override bool Equals(object obj)\n    {\n        if (obj == null || GetType() != obj.GetType())\n            return false;\n\n        Product other = (Product)obj;\n        return Name == other.Name;\n    }\n\n    public override int GetHashCode()\n    {\n        return Name.GetHashCode();\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        // Sample list of OrderLines\n        List<OrderLine> orderLines = new List<OrderLine>\n        {\n            new OrderLine { Product = new Product { Name = "ProductA" } },\n            new OrderLine { Product = new Product { Name = "ProductB" } }\n        };\n\n        // Item to compare\n        OrderLine myLine = new OrderLine { Product = new Product { Name = "ProductA" } };\n\n        // Check if any order line contains the same product\n        bool contains = orderLines.Any(ol => ol.Product.Equals(myLine.Product));\n\n        if (contains)\n        {\n            Console.WriteLine("The list contains an item with the same product.");\n        }\n        else\n        {\n            Console.WriteLine("The list does not contain an item with the same product.");\n        }\n    }\n}