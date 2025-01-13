using System;\nusing System.Collections.Generic;\n\npublic class PriorityQueue<T> where T : IComparable<T>\n{\n    private readonly List<T> elements = new List<T>();\n\n    public int Count => elements.Count;\n\n    public void Enqueue(T item)\n    {\n        elements.Add(item);\n        elements.Sort();\n    }\n\n    public T Dequeue()\n    {\n        if (Count > 0)\n        {\n            var ret = elements[0];\n            elements.RemoveAt(0);\n            return ret;\n        }\n        throw new InvalidOperationException("Queue is empty.");\n    }\n}\n\npublic class Node\n{\n    public int Id { get; set; }\n    public List<Edge> Edges { get; set; } = new List<Edge>();\n\n    public override bool Equals(object obj)\n    {\n        if (obj is not Node node) return false;\n        return Id == node.Id;\n    }\n\n    public override int GetHashCode()\n    {\n        return Id.GetHashCode();\n    }\n}\n\npublic class Edge\n{\n    public Node Target { get; set; }\n    public int Weight { get; set; } // Priority\n\n    public Edge(Node target, int weight)\n    {\n        Target = target;\n        Weight = weight;\n    }\n\n    public override bool Equals(object obj)\n    {\n        if (obj is not Edge edge) return false;\n        return Target.Id == edge.Target.Id && Weight == edge.Weight;\n    }\n\n    public override int GetHashCode()\n    {\n        return HashCode.Combine(Target.Id, Weight);\n    }\n}\n\npublic class Graph\n{\n    private readonly Dictionary<int, Node> nodes = new Dictionary<int, Node>();\n\n    public void AddNode(int id)\n    {\n        nodes[id] = new Node { Id = id };\n    }\n\n    public void AddEdge(int fromId, int toId, int weight)\n    {\n        if (!nodes.ContainsKey(fromId)) throw new InvalidOperationException("From node not present.");\n        if (!nodes.ContainsKey(toId)) throw new InvalidOperationException("To node not present.");\n        \n        nodes[fromId].Edges.Add(new Edge(nodes[toId], weight));\n    }\n\n    public void FindPath(int start, int end)\n    {\n        var queue = new PriorityQueue<Node>();\n        var distances = new Dictionary<int, double>();\n        var previous = new Dictionary<int, Node>();\n\n        foreach (var n in nodes.Values)\n        {\n            if (n.Id == start)\n            {\n                distances[n.Id] = 0;\n                queue.Enqueue(n);\n            }\n            else\n            {\n                distances[n.Id] = double.PositiveInfinity;\n            }\n\n            previous[n.Id] = null;\n        }\n\n        while (queue.Count > 0)\n        {\n            var n = queue.Dequeue();\n\n            if (n != null && n.Id == end) break;\n\n            foreach (var edge in n.Edges)\n            {\n                var alt = distances[n.Id] + edge.Weight;\n\n                if (alt < distances[edge.Target.Id])\n                {\n                    distances[edge.Target.Id] = alt;\n                    previous[edge.Target.Id] = n;\n                    queue.Enqueue(edge.Target);\n                }\n            }\n        }\n\n        // Backtrack to find the path\n        var stack = new Stack<Node>();\n        Node u = nodes[end];\n        while (u != null)\n        {\n            stack.Push(u);\n            u = previous[u.Id];\n        }\n\n        while (stack.Count > 0 && stack.Count > 1)\n        {\n            var fromNode = stack.Pop();\n            var toNode = stack.Peek();\n            Console.WriteLine($"{fromNode.Id},{toNode.Id}");\n        }\n    }\n}