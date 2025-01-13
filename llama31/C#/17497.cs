public interface IReadWrite\n{\n    string Foo { get; set; }\n}\n\npublic abstract class Parent\n{\n    public abstract string Foo { get; }\n}\n\npublic class ReadOnlyChild : Parent\n{\n    public override string Foo => "Get the property";\n}\n\npublic class ReadWriteChild : Parent, IReadWrite\n{\n    public string Foo\n    {\n        get => "Get the property";\n        set => // Set the property\n    }\n}