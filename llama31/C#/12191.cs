List<List<UInt32>> sortedList = unsortedList.Where(x => x.Count > 0).OrderBy(x => x[0]).ToList();