public class CartItem\n{\n    public string Name { get; set; }\n    public decimal Price { get; set; }\n    public double Weight { get; set; }\n}\n\npublic class DescriptionText\n{\n    public string Text { get; set; }\n}\n\npublic class ShoppingCart\n{\n    private List<object> items = new List<object>();\n\n    public void AddCartItem(CartItem item)\n    {\n        items.Add(item);\n    }\n\n    public void AddDescriptionText(DescriptionText text)\n    {\n        items.Add(text);\n    }\n\n    public decimal CalculateTotalPrice()\n    {\n        decimal totalPrice = 0;\n        foreach (var item in items)\n        {\n            if (item is CartItem cartItem)\n            {\n                totalPrice += cartItem.Price;\n            }\n        }\n        return totalPrice;\n    }\n\n    public double CalculateTotalWeight()\n    {\n        double totalWeight = 0;\n        foreach (var item in items)\n        {\n            if (item is CartItem cartItem)\n            {\n                totalWeight += cartItem.Weight;\n            }\n        }\n        return totalWeight;\n    }\n\n    public void DisplayItems()\n    {\n        foreach (var item in items)\n        {\n            if (item is CartItem cartItem)\n            {\n                Console.WriteLine($"CartItem: {cartItem.Name}, Price: {cartItem.Price}, Weight: {cartItem.Weight}");\n            }\n            else if (item is DescriptionText descriptionText)\n            {\n                Console.WriteLine($"Description: {descriptionText.Text}");\n            }\n        }\n    }\n}