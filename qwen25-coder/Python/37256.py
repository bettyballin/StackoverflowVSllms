import os\nfrom datetime import datetime\n\ndef get_file_modified_time(file_path):\n    # Get the last modified time as a timestamp\n    modified_time = os.path.getmtime(file_path)\n    \n    # Convert the timestamp to a readable date and time format\n    readable_time = datetime.fromtimestamp(modified_time)\n    \n    return readable_time\n\n# Example usage\nfile_path = 'example.txt'\nprint(f"Last modified time: {get_file_modified_time(file_path)}")