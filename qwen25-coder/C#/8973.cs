using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic class NewsManager\n{\n    private readonly Dictionary<string, int> _tagCache = new Dictionary<string, int>();\n    private readonly string _connectionString;\n\n    public NewsManager(string connectionString)\n    {\n        _connectionString = connectionString;\n        LoadTagsFromDatabase();\n    }\n\n    // Load all tags into memory at startup or periodically refresh cache\n    private void LoadTagsFromDatabase()\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        {\n            connection.Open();\n            using (var command = new SqlCommand("SELECT ID, Tag FROM Tags", connection))\n            using (var reader = command.ExecuteReader())\n            {\n                _tagCache.Clear();\n                while (reader.Read())\n                {\n                    int id = reader.GetInt32(0);\n                    string tag = reader.GetString(1);\n                    _tagCache[tag] = id;\n                }\n            }\n        }\n    }\n\n    // Insert news with correct TagID\n    public void InsertNews(List<NewsItem> newsItems)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        {\n            connection.Open();\n            foreach (var news in newsItems)\n            {\n                int tagId;\n                if (!_tagCache.TryGetValue(news.Tag, out tagId))\n                {\n                    // If Tag not found, insert it and update the cache\n                    using (var command = GetInsertTagCommand(connection, news.Tag))\n                    {\n                        var result = command.ExecuteScalar();\n                        if (result != null)\n                        {\n                            tagId = Convert.ToInt32(result);\n                            _tagCache[news.Tag] = tagId;\n                        }\n                    }\n                }\n\n                // Insert news with the found/created TagID\n                using (var command = GetInsertNewsCommand(connection, news.Title, tagId))\n                {\n                    command.ExecuteNonQuery();\n                }\n            }\n        }\n    }\n\n    private SqlCommand GetInsertTagCommand(SqlConnection connection, string tag)\n    {\n        var command = new SqlCommand("INSERT INTO Tags(Tag) OUTPUT INSERTED.ID VALUES(@Tag)", connection);\n        command.Parameters.AddWithValue("@Tag", tag);\n        return command;\n    }\n\n    private SqlCommand GetInsertNewsCommand(SqlConnection connection, string title, int tagId)\n    {\n        var command = new SqlCommand("INSERT INTO News(Title, TagID) VALUES(@Title, @TagID)", connection);\n        command.Parameters.AddWithValue("@Title", title);\n        command.Parameters.AddWithValue("@TagID", tagId);\n        return command;\n    }\n}\n\npublic class NewsItem\n{\n    public string Title { get; set; }\n    public string Tag { get; set; }\n}