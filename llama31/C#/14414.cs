public static IEnumerable<Range<T>> Collapse<T>(this IEnumerable<Range<T>> ranges, IComparer<T> comparer)\n{\n    var sortedRanges = ranges.OrderBy(r => r.Start, comparer);\n    var currentRange = default(Range<T>);\n\n    foreach (var range in sortedRanges)\n    {\n        if (currentRange == null || comparer.Compare(currentRange.End, range.Start) < 0)\n        {\n            if (currentRange != null) yield return currentRange;\n            currentRange = range;\n        }\n        else\n        {\n            currentRange.End = (comparer.Compare(currentRange.End, range.End) > 0) ? currentRange.End : range.End;\n        }\n    }\n\n    if (currentRange != null) yield return currentRange;\n}