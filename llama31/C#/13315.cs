// Using List<string>\nList<string> myList = new List<string>();\nmyList.Add("apple");\nmyList.Add("banana");\nmyList.Remove("apple");\n\n// Using String[]\nstring[] myArray = new string[] { "apple", "banana" };\n// myArray.Add("orange"); // Error: cannot add to a fixed-size array\n\n// Using HashSet<string>\nHashSet<string> mySet = new HashSet<string>();\nmySet.Add("apple");\nmySet.Add("banana");\nif (mySet.Contains("apple")) { Console.WriteLine("Apple exists!"); }