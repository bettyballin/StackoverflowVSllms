using System;\nusing System.Collections.Generic;\n\npublic class TreeNode\n{\n    public string Name { get; set; }\n    public string Parent { get; set; }\n    public List<TreeNode> Children { get; set; }\n\n    public TreeNode(string name, string parent)\n    {\n        Name = name;\n        Parent = parent;\n        Children = new List<TreeNode>();\n    }\n}\n\npublic class TreeParser\n{\n    public List<TreeNode> ParseUrls(List<string> urls)\n    {\n        List<TreeNode> nodes = new List<TreeNode>();\n\n        foreach (string url in urls)\n        {\n            string[] parts = url.Split('/');\n            TreeNode currentNode = null;\n\n            for (int i = 0; i < parts.Length; i++)\n            {\n                string part = parts[i];\n\n                if (i == 0)\n                {\n                    currentNode = GetOrCreateNode(nodes, part, null);\n                }\n                else\n                {\n                    currentNode = GetOrCreateNode(currentNode.Children, part, currentNode.Name);\n                }\n            }\n        }\n\n        return nodes;\n    }\n\n    private TreeNode GetOrCreateNode(List<TreeNode> nodes, string name, string parent)\n    {\n        TreeNode node = nodes.Find(n => n.Name == name);\n\n        if (node == null)\n        {\n            node = new TreeNode(name, parent);\n            nodes.Add(node);\n        }\n\n        return node;\n    }\n}