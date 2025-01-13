[System.Web.Services.WebMethod]\n[System.Web.Script.Services.ScriptMethod]\npublic static List<string> GetSuggestions(string prefixText, int count)\n{\n    // Return list of suggestions based on the prefixText\n    List<string> suggestions = new List<string> { "Apple", "Banana", "Cherry", "Date", "Elderberry" };\n    return suggestions.Where(s => s.StartsWith(prefixText, StringComparison.InvariantCultureIgnoreCase)).Take(count).ToList();\n}