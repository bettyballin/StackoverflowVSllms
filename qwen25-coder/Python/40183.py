import re\n\ndef mask_dates(input_file, output_file):\n    date_pattern = re.compile(r'\b\d{4}-\d{2}-\d{2}\b')\n    \n    with open(input_file, 'r') as file:\n        content = file.readlines()\n    \n    masked_content = [date_pattern.sub('DATE_MASK', line) for line in content]\n    \n    with open(output_file, 'w') as file:\n        file.writelines(masked_content)\n\n# Usage\nmask_dates('original_log.txt', 'masked_log.txt')