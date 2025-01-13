using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class Item\n{\n    public string Name { get; set; }\n    public double SortOrder { get; set; }\n\n    public Item(string name, double sortOrder)\n    {\n        Name = name;\n        SortOrder = sortOrder;\n    }\n}\n\npublic class SortManager\n{\n    private List<Item> _items;\n\n    public SortManager(List<Item> items)\n    {\n        _items = items.OrderBy(i => i.SortOrder).ToList();\n    }\n\n    public void MoveItemUp(int index)\n    {\n        if (index <= 0) return; // Already at the top\n\n        var prevItem = _items[index - 1];\n        var currItem = _items[index];\n\n        double newSortOrder = (prevItem.SortOrder + currItem.SortOrder) / 2;\n        currItem.SortOrder = newSortOrder;\n\n        RefreshSortOrders();\n    }\n\n    public void MoveItemDown(int index)\n    {\n        if (index >= _items.Count - 1) return; // Already at the bottom\n\n        var nextItem = _items[index + 1];\n        var currItem = _items[index];\n\n        double newSortOrder = (nextItem.SortOrder + currItem.SortOrder) / 2;\n        currItem.SortOrder = newSortOrder;\n\n        RefreshSortOrders();\n    }\n\n    private void RefreshSortOrders()\n    {\n        _items = _items.OrderBy(i => i.SortOrder).ToList();\n        for (int i = 0; i < _items.Count; i++)\n        {\n            _items[i].SortOrder = i;\n        }\n    }\n\n    public List<Item> GetItems()\n    {\n        return _items.OrderBy(i => i.SortOrder).ToList();\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var items = new List<Item>\n        {\n            new Item("Apples", 0),\n            new Item("Oranges", 1),\n            new Item("Pears", 2),\n            new Item("Banana", 3),\n            new Item("Pineapples", 4)\n        };\n\n        SortManager manager = new SortManager(items);\n        manager.MoveItemUp(2); // Move Pears up\n        manager.MoveItemDown(1); // Move Oranges down\n\n        foreach (var item in manager.GetItems())\n        {\n            Console.WriteLine($"{item.Name}, Order: {item.SortOrder}");\n        }\n    }\n}