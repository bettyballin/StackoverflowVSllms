class TreeNode:\n    def __init__(self, id, parent_id):\n        self.id = id\n        self.parent_id = parent_id\n        self.children = []\n\ndef build_tree(items):\n    # Dictionary to map id to TreeNode instance\n    nodes = {}\n    # List to hold TreeNode instances that potentially could be root nodes\n    potential_roots = []\n\n    # Create all tree nodes and put them in the dictionary\n    for item in items:\n        node = TreeNode(item['ID'], item['ParentID'])\n        nodes[item['ID']] = node\n\n    # Attach child nodes to their parent node if a valid parent is found.\n    # Else, add the node to potential_roots list\n    for node in nodes.values():\n        if node.parent_id is None or node.parent_id not in nodes:\n            potential_roots.append(node)\n        else:\n            parent_node = nodes[node.parent_id]\n            parent_node.children.append(node)\n\n    # Filter potential roots: a root node's ParentID must either be None\n    # or point to an id that does not exist in the dictionary\n    tree_roots = [node for node in potential_roots if node.parent_id is None]\n\n    return tree_roots\n\n# Usage:\nitems = [\n    {'ID': 1, 'ParentID': None},\n    {'ID': 2, 'ParentID': 1},\n    {'ID': 3, 'ParentID': 1},\n    {'ID': 4, 'ParentID': 2},\n    {'ID': 5, 'ParentID': None},  # Another root\n]\n\nroots = build_tree(items)\nfor root in roots:\n    print("Root", root.id)