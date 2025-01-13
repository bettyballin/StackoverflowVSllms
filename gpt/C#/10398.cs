public class Child\n{\n    public string Label;\n    public int CategoryNumber;\n    public int StorageId;\n}\n\npublic class Parent\n{\n    public string Label;\n    public List<Child> Children = new List<Child>();\n}\n\npublic static void Main()\n{\n    var parents = new List<Parent>();\n\n    var parent = new Parent() { Label = "P1" };\n    parent.Children.Add(new Child() { Label = "C1", CategoryNumber = 1, StorageId = 10 });\n    parent.Children.Add(new Child() { Label = "C2", CategoryNumber = 2, StorageId = 20 });\n    parents.Add(parent);\n\n    parent = new Parent() { Label = "P2" };\n    parent.Children.Add(new Child() { Label = "C3", CategoryNumber = 1, StorageId = 10 });\n    parent.Children.Add(new Child() { Label = "C4", CategoryNumber = 2, StorageId = 30 });\n    parents.Add(parent);\n\n    parent = new Parent() { Label = "P3" };\n    parent.Children.Add(new Child() { Label = "C5", CategoryNumber = 3, StorageId = 10 });\n    parent.Children.Add(new Child() { Label = "C6", CategoryNumber = 2, StorageId = 40 });\n    parents.Add(parent);\n\n    var selectedChildren = parents\n        .Where(p => p.Children.Any(c => c.CategoryNumber == 1))\n        .SelectMany(p => p.Children)\n        .Where(c => c.CategoryNumber == 2)\n        .ToList();\n\n    // Output the selected children\n    foreach (var child in selectedChildren)\n    {\n        Console.WriteLine($"{child.Label} {child.CategoryNumber} {child.StorageId}");\n    }\n}