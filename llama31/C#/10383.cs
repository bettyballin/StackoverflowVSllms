List<List<int>> listOfLists = ...;\nList<int> uniqueInts = listOfLists.SelectMany(x => x).Distinct().ToList();