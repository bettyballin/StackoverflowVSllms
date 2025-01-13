// Using Dictionary\nDictionary<string, int> dictionary = new Dictionary<string, int>();\ndictionary.Add("apple", 1);\nint appleCount = dictionary["apple"]; // No casting needed\n\n// Using Hashtable for comparison\nHashtable hashtable = new Hashtable();\nhashtable.Add("apple", 1);\nint hashtableAppleCount = (int)hashtable["apple"]; // Casting is required