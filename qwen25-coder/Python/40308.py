def reorder_name(name_string):\n    # Split the string by the comma and strip any extra spaces\n    parts = [part.strip() for part in name_string.split(',')]\n    # Return the reordered string\n    return ' '.join(parts[::-1])\n\n# Example usage\nname = "Doe, John"\nreordered_name = reorder_name(name)\nprint(reordered_name)  # Output: John Doe