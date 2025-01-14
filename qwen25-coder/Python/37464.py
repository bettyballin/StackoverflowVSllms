from fractions import Fraction\n\ndef float_to_fraction(value):\n    # Convert the float to a fraction with a maximum denominator of 100\n    f = Fraction(value).limit_denominator(100)\n    return f"{f.numerator}/{f.denominator}"\n\n# Example usage:\nprint(float_to_fraction(0.33))  # Outputs: "1/3"\nprint(float_to_fraction(0.4))   # Outputs: "2/5"