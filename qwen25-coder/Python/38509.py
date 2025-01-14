def transform_polynomial(coeffs, a, b, c, d):\n    """\n    Transforms the polynomial coefficients from one coordinate system to another.\n    \n    Args:\n    coeffs: List of polynomial coefficients from highest degree to constant term.\n            For example, [a_n, a_(n-1), ..., a_0] for a_n*x^n + ... + a_0\n    a: Scale factor in X direction\n    b: Translation factor in X direction\n    c: Scale factor in Y direction\n    d: Translation factor in Y direction\n    \n    Returns:\n    List of transformed polynomial coefficients.\n    """\n    n = len(coeffs) - 1  # Degree of the polynomial\n    x = sympy.Symbol('x')\n    original_poly = sum(coeffs[i] * x**(n-i) for i in range(len(coeffs)))\n    transformed_x = (x - b) / a  # Inverse of X' = aX + b is X = (X' - b)/a\n    intermediate_y = original_poly.subs(x, transformed_x)\n    final_y = c * intermediate_y + d\n    \n    # Expand and collect to get new polynomial coefficients\n    expanded_poly = sympy.expand(final_y)\n    return [expanded_poly.coeff(x, i) for i in range(n, -1, -1)]\n\n# Example usage:\ncoeffs = [2, 3, 5]  # Represents 2x^2 + 3x + 5\na, b, c, d = 2, 1, 3, 4  # Transformation parameters: X' = 2X + 1, Y' = 3Y + 4\ntransformed_coeffs = transform_polynomial(coeffs, a, b, c, d)\nprint("Transformed coefficients:", transformed_coeffs)