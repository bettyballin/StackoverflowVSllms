def replace_placeholders(pcl_path, output_path, replacements):\n    with open(pcl_path, 'r') as file:\n        pcl_content = file.read()\n\n    for placeholder, actual_value in replacements.items():\n        pcl_content = pcl_content.replace(placeholder, actual_value)\n\n    with open(output_path, 'w') as file:\n        file.write(pcl_content)\n\nif __name__ == "__main__":\n    pcl_path = "template.pcl"\n    output_path = "output.pcl"\n    replacements = {\n        "{PLACEHOLDER_1}": "Actual Value 1",\n        "{PLACEHOLDER_2}": "Actual Value 2",\n        # Add more replacements as needed\n    }\n\n    replace_placeholders(pcl_path, output_path, replacements)