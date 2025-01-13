using System;\nusing System.Collections.Generic;\n\npublic static class IListExtensions\n{\n    public static void Sort<T>(this IList<T> list, IComparer<T> comparer = null)\n    {\n        var sortableList = new List<T>(list);\n        sortableList.Sort(comparer);\n        for (int i = 0; i < list.Count; i++)\n            list[i] = sortableList[i];\n    }\n}