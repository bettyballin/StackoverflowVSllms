var selected = items.Where(item => item.Something > 10).ToList();\nselected.ForEach(item => items.Remove(item));\notherList.AddRange(selected);