def prob_consecutive_ones(N, X):\n    # p[i][0] -> number of sequences of length i that do not contain X consecutive ones ending in 0\n    # p[i][1] -> number of sequences of length i that do not contain X consecutive ones ending in 1\n    p = [[0 for _ in range(2)] for _ in range(N + 1)]\n    \n    p[0][0], p[0][1] = 1, 1\n    \n    for i in range(1, N):\n        p[i][0] = p[i-1][0] + p[i-1][1]\n        if i < X - 1:\n            p[i][1] = p[i-1][0]\n        else:\n            p[i][1] = sum(p[i-k][0] for k in range(1, X+1))\n    \n    # Total number of sequences not having X consecutive ones\n    total_no_X_consec_ones = p[N-1][0] + p[N-1][1]\n    total_sequences = 2 ** N\n    \n    return 1 - (total_no_X_consec_ones / float(total_sequences))\n\n# Example usage\nN = 32  # Total number of bits\nX = 4   # Consecutive 1s to check for\nprint(prob_consecutive_ones(N, X))