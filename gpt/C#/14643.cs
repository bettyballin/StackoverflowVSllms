public async Task<HomePageData> GetHomePageDataAsync()\n{\n    var homePageData = new HomePageData();\n\n    using (var connection = new SqlConnection(connectionString))\n    using (var command = new SqlCommand("GetHomePageData", connection))\n    {\n        command.CommandType = CommandType.StoredProcedure;\n        await connection.OpenAsync();\n\n        using (var reader = await command.ExecuteReaderAsync())\n        {\n            // Headlines\n            homePageData.Headlines = await ReadNewsAsync(reader);\n\n            // Move to next result set\n            await reader.NextResultAsync();\n\n            // Spot news\n            homePageData.SpotNews = await ReadNewsAsync(reader);\n\n            // Move to next result set\n            await reader.NextResultAsync();\n\n            // Spots with pictures\n            homePageData.SpotsWithPictures = await ReadNewsAsync(reader);\n\n            // Move to next result set\n            await reader.NextResultAsync();\n\n            // Most read news\n            homePageData.MostReadNews = await ReadNewsAsync(reader);\n\n            // Move to next result set\n            await reader.NextResultAsync();\n\n            // Most commented news\n            homePageData.MostCommentedNews = await ReadNewsAsync(reader);\n\n            // Move to next result set\n            await reader.NextResultAsync();\n\n            // News by category\n            homePageData.NewsByCategory = await ReadNewsByCategoryAsync(reader);\n        }\n    }\n\n    return homePageData;\n}\n\nprivate async Task<List<News>> ReadNewsAsync(SqlDataReader reader)\n{\n    var newsList = new List<News>();\n\n    while (await reader.ReadAsync())\n    {\n        var news = new News\n        {\n            Id = reader.GetInt32(0),\n            Title = reader.GetString(1),\n            // Map other fields\n        };\n        newsList.Add(news);\n    }\n\n    return newsList;\n}\n\nprivate async Task<Dictionary<string, List<News>>> ReadNewsByCategoryAsync(SqlDataReader reader)\n{\n    var newsByCategory = new Dictionary<string, List<News>>();\n\n    while (await reader.ReadAsync())\n    {\n        var category = reader.GetString(0);\n        var news = new News\n        {\n            Title = reader.GetString(1),\n            // Map other fields\n        };\n\n        if (!newsByCategory.ContainsKey(category))\n        {\n            newsByCategory[category] = new List<News>();\n        }\n        newsByCategory[category].Add(news);\n    }\n\n    return newsByCategory;\n}