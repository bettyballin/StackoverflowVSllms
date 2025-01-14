def parse_tapemacs_file(file_path, record_layout):\n    """\n    Parses a TapeMACS-like formatted file based on provided record layout.\n    \n    :param file_path: Path to the TapemacS text file.\n    :param record_layout: List of dictionaries containing field information:\n                        {'name': 'Field Name', \n                         'start_pos': start position (0-indexed), \n                         'end_pos': end position, \n                         'description': 'Field Description'}\n    :return: List of dictionaries with parsed records\n    """\n    records = []\n    with open(file_path, 'r') as file:\n        for line in file:\n            record = {}\n            for field in record_layout:\n                record[field['name']] = line[field['start_pos']:field['end_pos']].strip()\n            records.append(record)\n    return records\n\n# Example usage\nrecord_layout = [\n    {'name': 'Field1', 'start_pos': 0, 'end_pos': 5, 'description': 'First field'},\n    {'name': 'Field2', 'start_pos': 6, 'end_pos': 13, 'description': 'Second field'},\n    # Add more fields according to your actual data layout\n]\n\ndata = parse_tapemacs_file('path/to/your/file.txt', record_layout)\nfor record in data:\n    print(record)