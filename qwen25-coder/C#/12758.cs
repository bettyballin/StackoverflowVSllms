using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\n// Assuming you have your DataContext/DbContext named context\nvar tagIds = new List<int> { 2, 3, 4, 7 };\n\nvar matchingItems = (from item in context.Items\n                     join tagMap in context.TagMaps on item.ItemId equals tagMap.ItemId\n                     where tagIds.Contains(tagMap.TagId) && item.Active == true\n                     select item)\n                    .Distinct() // To ensure unique items only\n                    .ToList();