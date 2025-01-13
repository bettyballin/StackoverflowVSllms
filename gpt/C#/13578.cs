public void AnalyzeStatistics(List<Report> reports)\n    {\n        var averageWordCount = reports.Average(r => r.WordCount);\n        var stdDeviation = CalculateStandardDeviation(reports.Select(r => r.WordCount).ToList());\n        // Further analysis...\n    }