using QuickGraph;\nusing QuickGraph.Algorithms.ShortestPath;\n\n// define the graph\nvar graph = new AdjacencyGraph<string, Edge<string>>();\n\n// add vertices\ngraph.AddVertex("A");\ngraph.AddVertex("B");\ngraph.AddVertex("C");\ngraph.AddVertex("D");\n\n// add edges with weights\ngraph.AddEdge(new Edge<string>("A", "B"));\ngraph.AddEdge(new Edge<string>("B", "C"));\ngraph.AddEdge(new Edge<string>("C", "D"));\ngraph.AddEdge(new Edge<string>("A", "D"));\n\n// define edge weights\nvar edgeWeights = new Dictionary<Edge<string>, double>\n{\n    { new Edge<string>("A", "B"), 1.0 },\n    { new Edge<string>("B", "C"), 2.0 },\n    { new Edge<string>("C", "D"), 3.0 },\n    { new Edge<string>("A", "D"), 10.0 }\n};\n\n// run Dijkstra\nvar tryGetShortestPath = graph.ShortestPathsDijkstra(edgeWeights, "A");\n\n// get the shortest path\nif (tryGetShortestPath("D", out var shortestPath))\n{\n    Console.WriteLine("Shortest path from A to D:");\n    foreach (var edge in shortestPath)\n    {\n        Console.WriteLine(edge);\n    }\n}