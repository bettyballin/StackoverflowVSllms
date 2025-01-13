public List<Item> GetTwoRandomItems(int userId)\n{\n    // Get all possible combinations\n    var combinations = GenerateCombinations();\n\n    // Get viewed combinations for the user\n    var viewedCombinations = GetViewedCombinations(userId);\n\n    // Filter out viewed combinations\n    var availableCombinations = combinations.Except(viewedCombinations);\n\n    // Pick a random combination\n    var randomCombination = availableCombinations.OrderBy(c => Guid.NewGuid()).First();\n\n    // Return the two items\n    return new List<Item> { GetItem(randomCombination.Item1Id), GetItem(randomCombination.Item2Id) };\n}\n\nprivate List<Combination> GenerateCombinations()\n{\n    var items = GetItems();\n    var combinations = new List<Combination>();\n\n    for (int i = 0; i < items.Count; i++)\n    {\n        for (int j = i + 1; j < items.Count; j++)\n        {\n            combinations.Add(new Combination { Item1Id = items[i].Id, Item2Id = items[j].Id });\n        }\n    }\n\n    return combinations;\n}\n\nprivate List<Combination> GetViewedCombinations(int userId)\n{\n    // SQL query to get viewed combinations for the user\n    var query = "SELECT c.* FROM Combinations c JOIN Ratings r ON c.CombinationId = r.CombinationId WHERE r.UserId = @UserId";\n    var viewedCombinations = ExecuteQuery<Combination>(query, new { UserId = userId });\n    return viewedCombinations.ToList();\n}\n\nprivate Item GetItem(int itemId)\n{\n    // SQL query to get an item by ID\n    var query = "SELECT * FROM Items WHERE Id = @ItemId";\n    var item = ExecuteQuery<Item>(query, new { ItemId = itemId }).FirstOrDefault();\n    return item;\n}\n\npublic class Combination\n{\n    public int CombinationId { get; set; }\n    public int Item1Id { get; set; }\n    public int Item2Id { get; set; }\n}