using System;\nusing System.Text;\nusing System.Xml;\n\npublic class XmlHelper\n{\n    public static string RemoveIllegalXmlCharacters(string input)\n    {\n        if (string.IsNullOrEmpty(input))\n        {\n            return input;\n        }\n\n        StringBuilder output = new StringBuilder(input.Length);\n\n        foreach (char ch in input)\n        {\n            if (XmlConvert.IsXmlChar(ch))\n            {\n                output.Append(ch);\n            }\n        }\n\n        return output.ToString();\n    }\n}