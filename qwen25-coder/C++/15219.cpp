// Example: Adjacency List in C++\n   #include <iostream>\n   #include <vector>\n\n   int main() {\n       int nodes = 5;\n       std::vector<std::vector<int>> graph(nodes);\n\n       // Add edges to the graph\n       graph[0].push_back(1);\n       graph[1].push_back(2);\n       graph[2].push_back(3);\n       graph[3].push_back(4);\n       graph[4].push_back(0);\n\n       return 0;\n   }