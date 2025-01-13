public class WatermarkedApp\n{\n    private readonly string _uniqueKey;\n\n    public WatermarkedApp(string uniqueKey)\n    {\n        _uniqueKey = uniqueKey;\n    }\n\n    public void Execute()\n    {\n        // Use `_uniqueKey` for watermark operations\n        Console.WriteLine("Running with key: " + _uniqueKey);\n    }\n}