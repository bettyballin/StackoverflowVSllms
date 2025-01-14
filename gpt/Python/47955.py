def count_valid_arrangements(n):\n    if n <= 3:\n        return 2 ** n - 1  # For n <= 3, we manually check all possibilities\n    \n    # Array to store the number of valid linear arrangements\n    dp = [0] * (n + 1)\n    dp[0] = 1\n    dp[1] = 2\n    \n    for i in range(2, n + 1):\n        dp[i] = dp[i-1] + dp[i-2]\n        \n    # Calculate the number of valid circular arrangements\n    dp_circular = dp[n-1] + dp[n-3]\n    \n    return dp_circular\n\nn = int(input("Enter the value of n: "))\nprint(f"Number of valid arrangements for n={n}: {count_valid_arrangements(n)}")