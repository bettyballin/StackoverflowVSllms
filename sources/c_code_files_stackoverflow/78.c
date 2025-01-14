pp
#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/lengauer_tarjan_dominator_tree.hpp>

int main() {
    // Create an empty directed graph
    boost::adjacency_list<> g;

    // Add vertices and edges to the graph...

    // Create a dominator tree
    boost::lengauer_tarjan_dominator_tree_without_dfs(g);

    return 0;
}