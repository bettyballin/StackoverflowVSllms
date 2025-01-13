public List<News> GetTodaysNews()\n{\n    // Cache key and duration\n    const string cacheKey = "TodayNews";\n    var cacheDuration = TimeSpan.FromHours(24); // 24 hours\n\n    // Check if data is already in cache\n    var todayNews = HttpRuntime.Cache.Get(cacheKey) as List<News>;\n    \n    if (todayNews == null)\n    {\n        // Fetch all news for the current day from the database\n        using (var context = new NewsContext())\n        {\n            var dateToday = DateTime.Today;\n            todayNews = context.NewsItems\n                .Where(n => n.PublishDate.Date == dateToday)\n                .ToList();\n        }\n\n        // Store in cache\n        HttpRuntime.Cache.Insert(\n            cacheKey, \n            todayNews,\n            null, // no dependencies\n            DateTime.Now.Add(cacheDuration),\n            System.Web.Caching.Cache.NoSlidingExpiration);\n    }\n\n    return todayNews;\n}