public interface IModule\n{\n    string Name { get; }\n    string Description { get; }\n    void Initialize();\n    void Execute();\n}