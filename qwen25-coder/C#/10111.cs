using System;\nusing System.Collections.Generic;\n\npublic class TreeNode\n{\n    public string Name { get; set; }\n    public int Id { get; set; }\n    public List<TreeNode> Children { get; set; }\n\n    public TreeNode(string name, int id)\n    {\n        Name = name;\n        Id = id;\n        Children = new List<TreeNode>();\n    }\n}\n\npublic class TreeTraversal\n{\n    public static void TraverseIterative(TreeNode root)\n    {\n        if (root == null) return;\n\n        Stack<TreeNode> stack = new Stack<TreeNode>();\n        stack.Push(root);\n\n        while (stack.Count > 0)\n        {\n            TreeNode node = stack.Pop();\n            Console.WriteLine($"ID: {node.Id}, Name: {node.Name}");\n\n            // Push children onto the stack in reverse order\n            for (int i = node.Children.Count - 1; i >= 0; i--)\n            {\n                stack.Push(node.Children[i]);\n            }\n        }\n    }\n\n    public static void Main(string[] args)\n    {\n        // Example tree creation\n        TreeNode root = new TreeNode("Root", 1);\n        root.Children.Add(new TreeNode("Child1", 2));\n        root.Children[0].Children.Add(new TreeNode("Grandchild1", 3));\n        root.Children.Add(new TreeNode("Child2", 4));\n\n        TraverseIterative(root);\n    }\n}