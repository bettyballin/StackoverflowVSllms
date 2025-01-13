[ImportMany(typeof(ExtendedArtifactBase), AllowRecomposition = true)]\nprivate Lazy<ExtendedArtifactBase, IDictionary<string, object>>[] _artifacts { get; set; }\n\npublic ExtendedArtifactBase GetArtifact(string applicationName)\n{\n    return _artifacts\n        .FirstOrDefault(a => a.Metadata["Application"].Equals(applicationName))\n        ?.Value;\n}