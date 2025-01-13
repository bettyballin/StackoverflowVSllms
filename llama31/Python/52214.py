def guess_and_check(sequence):\n    for degree in range(1, len(sequence) + 1):\n        coefficients = []\n        for i in range(degree + 1):\n            coefficients.append(sequence[i])\n        polynomial = np.poly1d(coefficients)\n        if all(polynomial(i) == sequence[i] for i in range(len(sequence))):\n            return polynomial\n    return None\n\n# Example usage:\nsequence = [1, 3, 6, 10, 15]\npolynomial = guess_and_check(sequence)\nprint(polynomial)  # Output: 1 x^2 + 1 x