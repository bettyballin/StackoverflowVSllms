string source = "Hello world, world is nice.";\nstring pattern = "world";\nint[] indexes = FindIndexes(source, pattern);\nConsole.WriteLine(string.Join(", ", indexes)); // Output: 6, 13