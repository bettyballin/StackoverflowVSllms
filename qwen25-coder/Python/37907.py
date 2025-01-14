# Assuming your PyJavaInstance is stored in the variable 'data'\nimport re\n\ndef extract_numbers(data):\n    numbers = []\n    # Convert the PyJavaInstance to a string representation if it's not iterable directly\n    data_str = str(data)\n    \n    # Use regular expression to find all floating point numbers in the string\n    number_strings = re.findall(r'-?\d+\.?\d*', data_str)\n    \n    # Convert found strings to floats and add them to the list\n    for num_str in number_strings:\n        try:\n            numbers.append(float(num_str))\n        except ValueError:\n            # In case of any conversion issues, you may want to handle or log this\n            print(f"Could not convert {num_str} to float.")\n    \n    return numbers\n\n# Example usage\ndata = [{ "string1": "foo", "xxx1": 123.45, "xxx2": 678.90, "string2": "bar" }]\nextracted_numbers = extract_numbers(data)\nprint(extracted_numbers)  # Output should be [123.45, 678.9]