def min_cost_assignment(slots, pegs):\n    n = len(pegs)\n    m = len(slots)\n    dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]\n    \n    # Initialize the base case\n    dp[0][0] = 0\n\n    for i in range(1, n + 1):\n        for j in range(i, m + 1):\n            dp[i][j] = min(dp[i][j-1], dp[i-1][j-1] + abs(slots[j-1] - pegs[i-1]))\n\n    return dp[n][m]\n\n# Example usage\nslots = [0, 3, 5, 7, 10, 12]\npegs = [1, 4, 6, 8]\n\nprint(min_cost_assignment(slots, pegs))