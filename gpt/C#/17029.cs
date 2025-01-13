using Lucene.Net.Analysis.Standard;\nusing Lucene.Net.Documents;\nusing Lucene.Net.Index;\nusing Lucene.Net.Search;\nusing Lucene.Net.Store;\nusing Lucene.Net.Util;\nusing System;\n\npublic class LuceneExample\n{\n    private static readonly LuceneVersion AppLuceneVersion = LuceneVersion.LUCENE_48;\n\n    // Create an index writer\n    public static void CreateIndex(string indexPath, string[] data)\n    {\n        var dir = FSDirectory.Open(indexPath);\n        var analyzer = new StandardAnalyzer(AppLuceneVersion);\n        var indexConfig = new IndexWriterConfig(AppLuceneVersion, analyzer);\n        using var writer = new IndexWriter(dir, indexConfig);\n\n        foreach (var text in data)\n        {\n            var doc = new Document\n            {\n                new StringField("name", text, Field.Store.YES),\n                new TextField("content", text, Field.Store.NO)\n            };\n            writer.AddDocument(doc);\n        }\n    }\n\n    // Search the index\n    public static void SearchIndex(string indexPath, string searchTerm)\n    {\n        var dir = FSDirectory.Open(indexPath);\n        var analyzer = new StandardAnalyzer(AppLuceneVersion);\n        using var reader = DirectoryReader.Open(dir);\n        var searcher = new IndexSearcher(reader);\n\n        var queryParser = new QueryParser(AppLuceneVersion, "content", analyzer);\n        var query = queryParser.Parse(searchTerm);\n\n        var hits = searcher.Search(query, 10).ScoreDocs;\n\n        foreach (var hit in hits)\n        {\n            var foundDoc = searcher.Doc(hit.Doc);\n            Console.WriteLine($"Found: {foundDoc.Get("name")}");\n        }\n    }\n\n    public static void Main()\n    {\n        string indexPath = @"C:\LuceneIndex";\n        string[] data = { "foo bar baz", "baz qux quux", "foo quux" };\n\n        CreateIndex(indexPath, data);\n        SearchIndex(indexPath, "foo");\n    }\n}