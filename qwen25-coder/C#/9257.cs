using System;\n\n[AttributeUsage(AttributeTargets.Assembly, Inherited = false)]\npublic sealed class BuildDateAttribute : Attribute\n{\n    public BuildDateAttribute(string date) => Date = date;\n    public string Date { get; }\n}