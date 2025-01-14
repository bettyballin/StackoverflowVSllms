import re\n\ndef multi_replace(string, replacements):\n    # Create a regex from all the patterns in the dictionary keys\n    regex = re.compile("(%s)" % "|".join(map(re.escape, replacements.keys())))\n    \n    # For each match, look up the corresponding replacement\n    return regex.sub(lambda mo: replacements[mo.group(1)], string)\n\n# Example usage\ntext = "Some example text with 123S and other examples of 456S."\nreplacements_dict = {'\d+S': 'NUMBER'}\nresult = multi_replace(text, replacements_dict)\nprint(result)  # Output: Some example text with NUMBER and other examples of NUMBER.