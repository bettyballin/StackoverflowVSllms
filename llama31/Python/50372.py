import graphviz\n\n# Create a directed graph\ndot = graphviz.Digraph()\n\n# Add nodes\ndot.node('A', 'Start')\ndot.node('B', 'Process 1')\ndot.node('C', 'Process 2')\ndot.node('D', 'End')\n\n# Add edges\ndot.edge('A', 'B')\ndot.edge('B', 'C')\ndot.edge('C', 'D')\n\n# Render the graph as ASCII art\nprint(dot.render('ascii'))