import os\n\ndef convert_to_utf8(input_file_path, output_folder, original_encoding='ISO-8859-1'):\n    # Ensure the output directory exists\n    if not os.path.exists(output_folder):\n        os.makedirs(output_folder)\n\n    # Construct the output file path\n    output_file_name = os.path.basename(input_file_path)\n    output_file_path = os.path.join(output_folder, output_file_name)\n\n    # Open the input file with the specified encoding\n    with open(input_file_path, 'r', encoding=original_encoding) as infile:\n        content = infile.read()\n\n    # Write the content to a new file in UTF-8 encoding\n    with open(output_file_path, 'w', encoding='utf-8') as outfile:\n        outfile.write(content)\n\n# Example usage\nconvert_to_utf8('path/to/your/input/file.txt', 'converted/')