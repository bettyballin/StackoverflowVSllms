using Microsoft.CodeAnalysis;\nusing Microsoft.CodeAnalysis.CSharp;\nusing Microsoft.CodeAnalysis.CSharp.Syntax;\n\npublic class BaseTypeFinder\n{\n    public BaseTypeFinder(SyntaxTree tree)\n    {\n        this.tree = tree;\n    }\n\n    public BaseType FindBaseType(ClassDeclarationSyntax classDeclaration)\n    {\n        var symbol = tree.GetSemanticModel().GetDeclaredSymbol(classDeclaration);\n        var baseType = symbol.BaseType;\n        return baseType;\n    }\n}