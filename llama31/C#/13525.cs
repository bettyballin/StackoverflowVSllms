[DataContract]\npublic class MyBusinessObject : IBindingList\n{\n    [DataMember]\n    public int Id { get; set; }\n\n    [DataMember]\n    public string Name { get; set; }\n\n    // ...\n}