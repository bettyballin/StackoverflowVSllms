using Newtonsoft.Json;\n   using System.IO;\n\n   class Program\n   {\n       static void Main(string[] args)\n       {\n           Level level = new Level\n           {\n               Name = "Tutorial",\n               Objects = new List<string> { "Tree", "Rock" },\n               TerrainTypes = new List<string> { "Grass", "Water" }\n           };\n\n           // Serialize to JSON and save to a file\n           string json = JsonConvert.SerializeObject(level, Formatting.Indented);\n           File.WriteAllText("level.json", json);\n\n           // Load from file and deserialize\n           string loadedJson = File.ReadAllText("level.json");\n           Level loadedLevel = JsonConvert.DeserializeObject<Level>(loadedJson);\n       }\n   }