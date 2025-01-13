using Saxon.Api;\nusing System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a Processor instance.\n        Processor processor = new Processor();\n\n        // Load the source document.\n        DocumentBuilder documentBuilder = processor.NewDocumentBuilder();\n        XdmNode input = documentBuilder.Build(new Uri("file:///path/to/your/document.xml"));\n\n        // Create an XPath compiler.\n        XPathCompiler xpathCompiler = processor.NewXPathCompiler();\n\n        // Compile the XPath expression.\n        XPathExecutable executable = xpathCompiler.Compile("your-xpath-2.0-expression");\n\n        // Evaluate the expression.\n        XPathSelector selector = executable.Load();\n        selector.ContextItem = input;\n        XdmValue result = selector.Evaluate();\n\n        // Process the result.\n        foreach (XdmItem item in result)\n        {\n            Console.WriteLine(item.ToString());\n        }\n    }\n}