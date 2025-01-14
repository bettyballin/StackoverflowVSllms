def distance_to_line(A, B, P):\n    x1, y1 = A\n    x2, y2 = B\n    xp, yp = P\n    \n    # Calculate the perpendicular distance from point P to line AB\n    numerator = abs((y2 - y1) * xp + (x1 - x2) * yp + x2 * y1 - y2 * x1)\n    denominator = ((y2 - y1)**2 + (x1 - x2)**2)**0.5\n    \n    if denominator == 0:\n        return float('inf')  # The line is a point, distance is undefined or infinite\n    else:\n        return numerator / denominator\n\n# Example usage\nA = (1, 2)\nB = (4, 6)\nP = (3, 3)\n\ndistance = distance_to_line(A, B, P)\nprint(f"The distance from point {P} to line through points {A} and {B} is: {distance}")\n\n# Define a threshold for proximity\nthreshold = 1.0\n\nif distance <= threshold:\n    print("Point is close to the line.")\nelse:\n    print("Point is not close to the line.")