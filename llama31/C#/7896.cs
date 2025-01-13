using System.ComponentModel.Design;\n\n// Load the assembly and its XML documentation file\nAssembly assembly = Assembly.LoadFrom("path/to/assembly.dll");\nstring xmlDocPath = "path/to/assembly.xml";\n\n// Create an instance of the DocumentationProvider\nDocumentationProvider provider = new DocumentationProvider(xmlDocPath);\n\n// Get the documentation for a specific type or member\nstring documentation = provider.GetDocumentation(assembly.GetType("MyType"));