private static readonly Regex tag_re = new Regex("({{.*}}");\n\npublic List<Token> Parse(IEnumerable<string> template)\n{\n    var result = new List<Token>();\n    // ...\n}