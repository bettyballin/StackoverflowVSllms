using System;\nusing Microsoft.CodeAnalysis;\nusing Microsoft.CodeAnalysis.Diagnostics;\n\n[DiagnosticAnalyzer(LanguageNames.CSharp)]\npublic class StaticMethodPresenceAnalyzer : DiagnosticAnalyzer\n{\n    public const string MethodName = "RequiredStaticMethod";\n    \n    private static readonly LocalizableString Title = "Missing required static method.";\n    private static readonly LocalizableString MessageFormat = $"Class must implement a {MethodName} static method.";\n    private static readonly LocalizableString Description = $"All domain classes should implement the {MethodName} static method.";\n    private const string Category = "Usage";\n\n    private static DiagnosticDescriptor Rule = new DiagnosticDescriptor("MY_RULE_ID", Title, MessageFormat, Category, DiagnosticSeverity.Warning, isEnabledByDefault: true, description: Description);\n\n    public override ImmutableArray<DiagnosticDescriptor> SupportedDiagnostics => ImmutableArray.Create(Rule);\n    \n    public override void Initialize(AnalysisContext context)\n    {\n        context.ConfigureGeneratedCodeAnalysis(GeneratedCodeAnalysisFlags.Analyze | GeneratedCodeAnalysisFlags.ReportDiagnostics);\n        context.EnableConcurrentExecution();\n        context.RegisterAction(AnalyzeMember, SyntaxKind.ClassDeclaration);\n    }\n\n    private static void AnalyzeMember(OperationAnalysisContext context)\n    {\n        var classSymbol = (INamedTypeSymbol)context.Symbol;\n        bool hasMethod = classSymbol.GetMembers(MethodName).Any(m => m.Kind == SymbolKind.Method && ((IMethodSymbol)m).IsStatic);\n\n        if (!hasMethod)\n        {\n            Diagnostic diagnostic = Diagnostic.Create(Rule, classSymbol.Locations.First());\n            context.ReportDiagnostic(diagnostic);\n        }\n    }\n}