[HasSelfValidation]\npublic class MyObject\n{\n    [ResourceStringValidator("MyResourceType", "MyResourceName")]\n    public string MyProperty { get; set; }\n}