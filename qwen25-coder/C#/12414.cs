using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a DateTime object with local kind\n        DateTime localDateTime = new DateTime(2023, 10, 5, 15, 30, 0, DateTimeKind.Local);\n        \n        // Convert to UTC\n        DateTime utcDateTimeFromLocal = localDateTime.ToUniversalTime();\n        Console.WriteLine("UTC from Local: " + utcDateTimeFromLocal);\n\n        // Create a DateTime object with UTC kind\n        DateTime utcDateTime = new DateTime(2023, 10, 5, 18, 30, 0, DateTimeKind.Utc);\n        \n        // Convert to UTC (should be the same)\n        DateTime sameUtcDateTime = utcDateTime.ToUniversalTime();\n        Console.WriteLine("Same UTC: " + sameUtcDateTime);\n    }\n}