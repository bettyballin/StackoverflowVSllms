using System;\nusing System.Windows;\nusing System.Windows.Markup;\nusing System.Windows.Documents;\n\npublic void InsertHtmlIntoFlowDocument(FlowDocument flowDoc, string htmlFragment)\n{\n    // Convert HTML to XAML using HTMLToXAMLConverter\n    string xamlString = HTMLToXAMLConverter.ConvertHtmlToXaml(htmlFragment, true);\n\n    // Parse the XAML string into a Block element\n    Block block = (Block)XamlReader.Parse(xamlString);\n\n    // Add the Block element to the FlowDocument\n    flowDoc.Blocks.Add(block);\n}