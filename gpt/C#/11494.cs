using System;\nusing System.Collections.Generic;\nusing System.Diagnostics;\n\n// Random number generator interface\npublic interface IRandomNumberGenerator\n{\n    int Next(int minValue, int maxValue);\n}\n\n// Actual random number generator\npublic class RandomNumberGenerator : IRandomNumberGenerator\n{\n    private Random _random = new Random();\n\n    public int Next(int minValue, int maxValue)\n    {\n        return _random.Next(minValue, maxValue);\n    }\n}\n\n// Mock random number generator for testing\npublic class MockRandomNumberGenerator : IRandomNumberGenerator\n{\n    private Queue<int> _values;\n\n    public MockRandomNumberGenerator(IEnumerable<int> values)\n    {\n        _values = new Queue<int>(values);\n    }\n\n    public int Next(int minValue, int maxValue)\n    {\n        return _values.Dequeue();\n    }\n}\n\n// Image selector\npublic class ImageSelector\n{\n    private IRandomNumberGenerator _randomNumberGenerator;\n    private List<string> _images;\n    private Dictionary<string, int> _imageCounts;\n    private int _maxCount;\n\n    public ImageSelector(IRandomNumberGenerator randomNumberGenerator, List<string> images, int maxCount)\n    {\n        _randomNumberGenerator = randomNumberGenerator;\n        _images = images;\n        _imageCounts = new Dictionary<string, int>();\n        _maxCount = maxCount;\n\n        foreach (var image in images)\n        {\n            _imageCounts[image] = 0;\n        }\n    }\n\n    public string GetRandomImage()\n    {\n        string selectedImage;\n        do\n        {\n            int index = _randomNumberGenerator.Next(0, _images.Count);\n            selectedImage = _images[index];\n        } while (_imageCounts[selectedImage] >= _maxCount);\n\n        _imageCounts[selectedImage]++;\n        return selectedImage;\n    }\n}\n\n// Example usage\npublic class Program\n{\n    public static void Main()\n    {\n        List<string> images = new List<string> { "img1", "img2", "img3" };\n        IRandomNumberGenerator rng = new RandomNumberGenerator();\n        ImageSelector imageSelector = new ImageSelector(rng, images, 2);\n\n        // Mock RNG for testing\n        IRandomNumberGenerator mockRng = new MockRandomNumberGenerator(new List<int> { 0, 1, 2, 0, 1, 2, 0, 1, 2 });\n        ImageSelector testImageSelector = new ImageSelector(mockRng, images, 2);\n\n        for (int i = 0; i < 6; i++)\n        {\n            string image = testImageSelector.GetRandomImage();\n            Console.WriteLine(image);\n        }\n\n        // Add assertions to validate expected behavior\n        Debug.Assert(testImageSelector.GetRandomImage() == "img3");\n        Debug.Assert(testImageSelector.GetRandomImage() == "img1");\n    }\n}