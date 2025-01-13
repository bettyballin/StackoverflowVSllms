using System.IO;\nusing System.Text;\nusing Lucene.Net.Analysis.Standard;\nusing Lucene.Net.Documents;\nusing Lucene.Net.Index;\nusing Lucene.Net.Store;\nusing Version = Lucene.Net.Util.Version;\n\nclass Program\n{\n    static void Main()\n    {\n        var directory = FSDirectory.Open(new DirectoryInfo(@"C:\path\to\index"));\n        using (var writer = new IndexWriter(directory, new StandardAnalyzer(Version.LUCENE_30), true, IndexWriter.MaxFieldLength.UNLIMITED))\n        {\n            var document = new Document();\n            document.Add(new StringField("id", "1", Field.Store.YES));\n            document.Add(new TextField("documentContent", File.ReadAllText(@"C:\path\to\yourfile.txt", Encoding.UTF8), Field.Store.NO));\n\n            writer.UpdateDocument(new Term("id", "1"), document);\n        }\n    }\n}