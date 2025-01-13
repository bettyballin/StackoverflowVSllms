import zipfile\nimport os\n\n# Path to your .egg file\negg_path = "C:\\Python25\\lib\\site-packages\\stompservice-0.1.0-py2.5.egg"\n\n# Directory to extract the contents to\nextract_dir = "C:\\Python25\\lib\\site-packages\\stompservice_extracted"\n\n# Create the extract directory if it doesn't exist\nos.makedirs(extract_dir, exist_ok=True)\n\n# Open and extract the .egg file\nwith zipfile.ZipFile(egg_path, 'r') as egg:\n    egg.extractall(extract_dir)\n\nprint(f"Contents extracted to {extract_dir}")