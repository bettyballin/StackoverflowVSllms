using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Text;\n\npublic class MarkovGenerator\n{\n    private readonly Dictionary<string, List<string>> _chains = new Dictionary<string, List<string>>();\n    private readonly Random _random = new Random();\n    private readonly int _order;\n\n    public MarkovGenerator(int order = 2)\n    {\n        _order = order;\n    }\n\n    public void Train(string input)\n    {\n        for (int i = 0; i < input.Length - _order; i++)\n        {\n            string key = input.Substring(i, _order);\n            string value = input.Substring(i + _order, 1);\n\n            if (!_chains.ContainsKey(key))\n            {\n                _chains[key] = new List<string>();\n            }\n            _chains[key].Add(value);\n        }\n    }\n\n    public string Generate(int length)\n    {\n        StringBuilder result = new StringBuilder();\n        int start = _random.Next(0, _chains.Keys.Count);\n        string current = new List<string>(_chains.Keys)[start];\n        result.Append(current);\n\n        for (int i = 0; i < length - _order; i++)\n        {\n            if (!_chains.ContainsKey(current))\n            {\n                break;\n            }\n\n            List<string> possibleNextChars = _chains[current];\n            string nextChar = possibleNextChars[_random.Next(0, possibleNextChars.Count)];\n            result.Append(nextChar);\n\n            current = current.Substring(1) + nextChar;\n        }\n\n        return result.ToString();\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        string sampleText = "Your sample training text goes here, it could be a large text of a book or any other natural language text.";\n        MarkovGenerator markov = new MarkovGenerator();\n        markov.Train(sampleText);\n\n        int targetSizeInBytes = 1_000_000_000; // 1GB\n        int chunkSize = 100_000; // Generate in chunks to avoid memory issues\n\n        using (StreamWriter writer = new StreamWriter("largeTextFile.txt"))\n        {\n            while (targetSizeInBytes > 0)\n            {\n                string chunk = markov.Generate(chunkSize);\n                writer.Write(chunk);\n                targetSizeInBytes -= Encoding.UTF8.GetByteCount(chunk);\n            }\n        }\n    }\n}