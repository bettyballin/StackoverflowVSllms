var trie = new DomainTrie();\n\ntrie.AddEntry("www.example.com");\ntrie.AddEntry("*.example.com");\n\nConsole.WriteLine(trie.Match("www.example.com"));  // True\nConsole.WriteLine(trie.Match("example.com"));  // True\nConsole.WriteLine(trie.Match("sub.www.example.com"));  // True\nConsole.WriteLine(trie.Match("other.com"));  // False