using System;\nusing System.Linq;\nusing System.Xml.Linq;\nusing System.Text;\n\npublic static class XElementExtensions\n{\n    public static string GetXPath(this XElement element)\n    {\n        if (element == null)\n            throw new ArgumentNullException(nameof(element));\n\n        StringBuilder xpath = new StringBuilder();\n        while (element != null)\n        {\n            int index = GetElementIndex(element);\n            xpath.Insert(0, $"/{element.Name}[{index}]");\n            element = element.Parent;\n        }\n        return xpath.ToString();\n    }\n\n    private static int GetElementIndex(XElement element)\n    {\n        if (element == null)\n            throw new ArgumentNullException(nameof(element));\n\n        int index = 1; // XPath is 1-based index\n        XElement sibling = element.ElementsBeforeSelf(element.Name).FirstOrDefault();\n        while (sibling != null)\n        {\n            index++;\n            sibling = sibling.ElementsBeforeSelf(element.Name).FirstOrDefault();\n        }\n        return index;\n    }\n}