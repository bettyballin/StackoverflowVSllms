using Microsoft.CodeAnalysis;\nusing Microsoft.CodeAnalysis.VisualBasic;\nusing Microsoft.CodeAnalysis.VisualBasic.Syntax;\n\n// Open the code file\nvar code = File.ReadAllText("example.vb");\n\n// Create a new VisualBasic syntax tree\nvar tree = VisualBasicSyntaxTree.ParseText(code);\n\n// Get the root node of the syntax tree\nvar root = tree.GetRoot();\n\n// Find all function and sub declarations\nvar functions = root.DescendantNodes()\n    .OfType<FunctionStatementSyntax>()\n    .Concat(root.DescendantNodes().OfType<SubStatementSyntax>());\n\n// Iterate over the functions and subs\nforeach (var func in functions)\n{\n    Console.WriteLine($"Function/Sub: {func.Identifier.Text}");\n\n    // Get the code within the function/sub\n    var codeWithin = func.Body.Statements.ToString();\n\n    Console.WriteLine($"Code within: {codeWithin}");\n}