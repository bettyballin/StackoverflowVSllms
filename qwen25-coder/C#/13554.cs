using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class PaginationHelper\n{\n    public static List<string> GetPage(List<string> docList, List<int> pageBreakList, int pageNum)\n    {\n        // Ensure valid page number (adjusting for 1-based index from external user input)\n        if (pageNum < 1) return docList.Take(0).ToList(); // Return empty list for invalid pages\n\n        // Calculate start and end indices for the requested page\n        int start = (pageNum - 1) * 10; // Assuming each page has up to 10 items\n        int end;\n\n        if (pageNum == 1 && !pageBreakList.Any())\n            end = Math.Min(10, docList.Count); // If there's only one page and no breaks\n        else if (pageNum > pageBreakList.Count + 1)\n            return docList.Skip(docList.Count - 1).Take(1).ToList(); // Return last item if requested page is out of range\n        else\n            end = pageNum <= pageBreakList.Count ? pageBreakList[pageNum - 2] : docList.Count;\n\n        // Retrieve and return the specified page\n        return docList.Skip(start).Take(end - start).ToList();\n    }\n}