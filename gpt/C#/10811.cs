public class AutomappingConfiguration : DefaultAutomappingConfiguration\n{\n    public override bool ShouldMap(Type type)\n    {\n        return type.Namespace == "YourNamespace"; // Adjust to your actual namespace\n    }\n\n    public override bool IsDiscriminated(Type type)\n    {\n        return typeof(UniqueNamedEntity).IsAssignableFrom(type);\n    }\n}