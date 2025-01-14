import xattr\n\n# Path to your file\nfile_path = '/path/to/your/file'\n\n# Desired new creation timestamp (e.g., January 1, 2023)\nnew_timestamp = '2023-01-01T00:00:00Z'  # Ensure this is a string format\n\n# Set the custom "creation time" attribute\nxattr.setxattr(file_path, 'user.creation_time', new_timestamp.encode())