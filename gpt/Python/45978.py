function hasPerfectMatching(tree):\n    n = number of nodes in tree\n    if n % 2 != 0:\n        return False  // A perfect matching is not possible if the number of nodes is odd\n    \n    visited = array of size n initialized to False\n\n    function dfs(node):\n        visited[node] = True\n        childCount = 0\n\n        for each child in tree[node]:\n            if not visited[child]:\n                if not dfs(child):\n                    return False\n                childCount += 1\n\n        // If node has odd number of children, it can't form a perfect matching\n        if childCount % 2 != 0:\n            return False\n        \n        return True\n\n    // Start DFS from any node, here assuming node 0\n    if dfs(0):\n        return True\n    else:\n        return False