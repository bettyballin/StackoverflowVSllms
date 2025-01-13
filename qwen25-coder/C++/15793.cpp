/* Inserts the node pointed to by "newNode" into the subtree rooted at "treeNode" */\nvoid InsertNode(Node* &treeNode, Node *newNode)\n{\n    if (treeNode == NULL) // If the tree is empty or we reach a leaf's child pointer\n        treeNode = newNode; // Place the new node here\n    else if (newNode->key < treeNode->key) // If the key to insert is less than current node's key\n        InsertNode(treeNode->left, newNode); // Recur into the left subtree\n    else // Otherwise, it goes in the right subtree\n        InsertNode(treeNode->right, newNode);\n}