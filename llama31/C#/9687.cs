using System.Linq;\n\npublic int FindMostOccurringNumber(List<int> numbers)\n{\n    return numbers.GroupBy(n => n)\n                  .OrderByDescending(g => g.Count())\n                  .First().Key;\n}