private static void a()\n{\n    List<string> list = new List<string> {"Box", "Gate", "Car"};\n    string searchString = "box"; // user-entered string\n    int index = list.FindIndex(item => item.Equals(searchString, StringComparison.OrdinalIgnoreCase));\n    // do something with the index\n}