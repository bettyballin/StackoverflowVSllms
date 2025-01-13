def swap_name_order(name):\n    # Split the name by the comma\n    parts = name.split(", ")\n    \n    # Ensure there are exactly two parts\n    if len(parts) != 2:\n        raise ValueError("Input should be in the format 'last name, first name'")\n    \n    # Swap the order and join them with a space\n    swapped_name = parts[1] + " " + parts[0]\n    \n    return swapped_name\n\n# Example usage\nname = "Doe, John"\nresult = swap_name_order(name)\nprint(result)  # Output: John Doe