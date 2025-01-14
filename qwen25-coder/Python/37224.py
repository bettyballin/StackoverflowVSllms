import os\nfrom datetime import datetime\n\nfilename = 'yourfile.txt'\n\n# Ensure the file exists\nif os.path.exists(filename):\n    # Get the last modified time in seconds since the epoch\n    mod_time = os.path.getmtime(filename)\n    \n    # Convert the timestamp to a readable format\n    readable_time = datetime.fromtimestamp(mod_time).strftime('%Y-%m-%d %H:%M:%S')\n    \n    print(f"The file was last modified at: {readable_time}")\nelse:\n    print("The file does not exist.")