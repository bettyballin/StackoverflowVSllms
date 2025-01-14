def write_fixed_width_file(filename, data):\n    with open(filename, 'w') as file:\n        for record in data:\n            # Create a fixed-width string\n            fixed_width_line = "{:<10}{:<10}{:<10}{:<10}{:<10}{:<10}{:<10}{:<10}".format(\n                record['field1'], record['field2'], record['field3'], record['field4'],\n                record['field5'], record['field6'], record['field7'], record['field8']\n            )\n            # Ensure the line is exactly 80 characters\n            fixed_width_line = fixed_width_line[:80].ljust(80)\n            file.write(fixed_width_line + "\n")\n\n# Example data\ndata = [\n    {'field1': 'Foo', 'field2': '', 'field3': '', 'field4': '', 'field5': '', 'field6': '', 'field7': '', 'field8': ''},\n    {'field1': 'Bar', 'field2': 'Baz', 'field3': '', 'field4': '', 'field5': '', 'field6': '', 'field7': '', 'field8': ''},\n]\n\nwrite_fixed_width_file("output.txt", data)