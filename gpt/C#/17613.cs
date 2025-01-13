using System.Collections.Generic;\nusing System.IO;\nusing NGettext;\n\nclass Program\n{\n    static void Main()\n    {\n        var translations = new Dictionary<string, string>\n        {\n            { "Hello, world!", "Hola, mundo!" },\n            { "Goodbye!", "¡Adiós!" }\n        };\n\n        var poFile = new PoFile();\n        foreach (var translation in translations)\n        {\n            poFile.Add(new CatalogEntry(translation.Key, translation.Value));\n        }\n\n        using (var poWriter = new StreamWriter("translations.po"))\n        {\n            poFile.Save(poWriter);\n        }\n\n        var moFile = new MoFile();\n        using (var poReader = new StreamReader("translations.po"))\n        {\n            moFile.Load(poReader);\n        }\n\n        using (var moWriter = new FileStream("translations.mo", FileMode.Create))\n        {\n            moFile.Save(moWriter);\n        }\n    }\n}