[DataContract]\npublic class InvalidInputFault\n{\n    [DataMember]\n    public Dictionary<string, string> Errors { get; private set; }\n\n    [DataMember]\n    public bool Fatal { get; private set; }\n\n    [DataMember]\n    public Guid SeriesIdentifier { get; private set; }\n\n    [DataMember]\n    public string Reason { get; private set; }\n\n    public InvalidInputFault(Guid id, string argument, string error, bool fatal, string reason)\n    {\n        SeriesIdentifier = id;\n        Errors = new Dictionary<string, string> {{argument, error}};\n        Fatal = fatal;\n        Reason = reason;\n    }\n\n    public void AddError(string argument, string error, bool fatal)\n    {\n        Errors.Add(argument, error);\n        Fatal |= fatal;\n    }\n}