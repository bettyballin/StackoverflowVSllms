def format_strings_for_sql(strings):\n    # Format each string with single quotes\n    formatted_strings = [f"'{s}'" for s in strings]\n    # Join all formatted strings with a comma\n    result_string = ', '.join(formatted_strings)\n    return f"({result_string})"\n\n# Example usage:\nmy_strings = ["apple", "banana", "cherry"]\nformatted_output = format_strings_for_sql(my_strings)\nprint(formatted_output)  # Output: ('apple', 'banana', 'cherry')