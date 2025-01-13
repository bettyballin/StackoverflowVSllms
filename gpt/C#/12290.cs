public class FooData {\n    public int Price { get; set; }\n    public int Quantity { get; set; }\n}\n\npublic class FooWrapper {\n    private FooData _data;\n\n    public FooWrapper(FooData data) {\n        _data = data;\n    }\n\n    public int Price {\n        get => _data.Price;\n        set => _data.Price = value;\n    }\n\n    public int Quantity {\n        get => _data.Quantity;\n        set => _data.Quantity = value;\n    }\n\n    public double GetTotal() {\n        return Price * Quantity;\n    }\n}\n\n// Usage\nFooData data = new FooData { Price = 10, Quantity = 20 };\nFooWrapper wrapper = new FooWrapper(data);\ndouble total = wrapper.GetTotal();