using Newtonsoft.Json;\n\npublic class MyClass\n{\n    [JsonProperty(NullValueHandling = NullValueHandling.Include)]\n    public string? MyNullableField { get; set; }\n}