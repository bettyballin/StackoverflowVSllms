public ClassA\n{\n    private readonly Collection<string> strings;\n\n    public Collection<string> Strings { get { return strings; } }\n\n    public ClassA(IEnumerable<string> strings)\n    {\n        this.strings = new Collection<string>(strings.ToList());\n    }\n}