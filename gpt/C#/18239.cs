[DataContract]\npublic class KeyValuePair\n{\n    [DataMember]\n    public string Key { get; set; }\n    [DataMember]\n    public string Value { get; set; }\n}\n\n[DataContract]\npublic class Example\n{\n    [DataMember]\n    public List<KeyValuePair> Items { get; set; }\n}