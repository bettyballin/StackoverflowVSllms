public class Node\n{\n    public string Name { get; set; }\n    // Add other properties if needed\n}\n\npublic class NodePair\n{\n    public Node StartNode { get; set; }\n    public Node EndNode { get; set; }\n\n    public NodePair(Node startNode, Node endNode)\n    {\n        StartNode = startNode;\n        EndNode = endNode;\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        List<NodePair> nodePairs = new List<NodePair>();\n\n        Node nodeA = new Node { Name = "A" };\n        Node nodeB = new Node { Name = "B" };\n        Node nodeC = new Node { Name = "C" };\n\n        nodePairs.Add(new NodePair(nodeA, nodeB));\n        nodePairs.Add(new NodePair(nodeB, nodeC));\n        nodePairs.Add(new NodePair(nodeA, nodeC));\n\n        // Example of accessing the data\n        foreach (var pair in nodePairs)\n        {\n            Console.WriteLine($"Start: {pair.StartNode.Name}, End: {pair.EndNode.Name}");\n        }\n    }\n}