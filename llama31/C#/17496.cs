public abstract class Parent\n{\n    public abstract string Foo { get; }\n}\n\npublic class ReadOnlyChild : Parent\n{\n    public override string Foo => "Get the property";\n}\n\npublic class ReadWriteChild : Parent\n{\n    public new string Foo\n    {\n        get => "Get the property";\n        set => // Set the property\n    }\n}