def comma_separated_string(lst):\n    return ','.join(lst)\n\nprint(comma_separated_string(['a', 'b', 'c']))  # Outputs: a,b,c\nprint(comma_separated_string(['s']))  # Outputs: s\nprint(comma_separated_string([]))  # Outputs: (empty string)