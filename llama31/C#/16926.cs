public class TrieNode\n{\n    public Dictionary<char, TrieNode> Children { get; set; }\n    public bool IsEndOfWord { get; set; }\n\n    public TrieNode()\n    {\n        Children = new Dictionary<char, TrieNode>();\n    }\n}\n\npublic class Trie\n{\n    private TrieNode root;\n\n    public Trie()\n    {\n        root = new TrieNode();\n    }\n\n    public void Add(string word)\n    {\n        var node = root;\n        foreach (var c in word)\n        {\n            if (!node.Children.TryGetValue(c, out var child))\n            {\n                child = new TrieNode();\n                node.Children[c] = child;\n            }\n            node = child;\n        }\n        node.IsEndOfWord = true;\n    }\n\n    public IEnumerable<string> Filter(string prefix)\n    {\n        var node = root;\n        foreach (var c in prefix)\n        {\n            if (!node.Children.TryGetValue(c, out var child))\n            {\n                return Enumerable.Empty<string>();\n            }\n            node = child;\n        }\n        return GetWords(node, prefix);\n    }\n\n    private IEnumerable<string> GetWords(TrieNode node, string prefix)\n    {\n        if (node.IsEndOfWord)\n        {\n            yield return prefix;\n        }\n        foreach (var child in node.Children.Values)\n        {\n            foreach (var word in GetWords(child, prefix + child.Key))\n            {\n                yield return word;\n            }\n        }\n    }\n}