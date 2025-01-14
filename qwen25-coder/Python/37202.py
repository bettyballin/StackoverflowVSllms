def count_combinations(target, coins):\n    dp = [0] * (target + 1)\n    dp[0] = 1\n\n    for coin in coins:\n        for amount in range(coin, target + 1):\n            dp[amount] += dp[amount - coin]\n\n    return dp[target]\n\n# British currency values in pence\ncoins = [1, 2, 5, 10, 20, 50, 100, 200]\ntarget_amount = 200  # £2 in pence\n\n# Calculate the number of combinations to make £2\nprint(count_combinations(target_amount, coins))