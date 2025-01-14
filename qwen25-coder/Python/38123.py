import numpy as np\n\ndef diaconis_winkler_algorithm(row_sums, col_sums, max_iterations=1000):\n    """\n    Generates a random contingency table with fixed row and column sums.\n    Uses the Diaconis-Winkler algorithm to maintain uniform distribution over tables.\n    \n    :param row_sums: List of row sums\n    :param col_sums: List of column sums\n    :param max_iterations: Maximum number of iterations for MCMC\n    :return: 2D numpy array representing the contingency table\n    """\n    rows = len(row_sums)\n    cols = len(col_sums)\n    \n    # Initialize a matrix with random values, constrained by row and col sums\n    table = np.random.rand(rows, cols) * 10\n    table *= np.repeat(np.array(row_sums) / table.sum(axis=1).reshape(-1, 1), cols, axis=1)\n    table *= np.tile(np.array(col_sums) / table.sum(axis=0).reshape(1, -1), (rows, 1))\n    \n    for _ in range(max_iterations):\n        # Sample a random pair of indices\n        i, j = np.random.choice(rows), np.random.choice(cols)\n        \n        if np.random.rand() < 0.5:\n            k = np.random.choice([m for m in range(rows) if m != i])\n            alpha = min(table[i, j] / table[k, j], table[k, j] / table[i, j])\n        else:\n            l = np.random.choice([n for n in range(cols) if n != j])\n            alpha = min(table[i, j] / table[i, l], table[i, l] / table[i, j])\n        \n        # Adjust the values\n        p = np.random.rand()\n        update = alpha * (0.5 - p)\n        table[i, j] += update\n        if np.random.rand() < 0.5:\n            table[k, j] -= update\n        else:\n            table[i, l] -= update\n    \n    # Ensure the table sums match row and col sums exactly by redistributing errors\n    for r in range(rows):\n        error = row_sums[r] - table[r].sum()\n        if abs(error) > 1e-6:\n            table[r] += error / cols\n\n    for c in range(cols):\n        error = col_sums[c] - table[:, c].sum()\n        if abs(error) > 1e-6:\n            table[:, c] += error / rows\n    \n    return np.round(table)\n\n# Example usage\nrow_sums = [20, 30]\ncol_sums = [25, 25]\nrandom_table = diaconis_winkler_algorithm(row_sums, col_sums)\nprint(random_table)