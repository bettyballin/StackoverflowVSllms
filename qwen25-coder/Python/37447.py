import os\nimport uuid\n\n# Function to set a UUID extended attribute\ndef set_uuid_attribute(file_path):\n    unique_id = str(uuid.uuid4())\n    os.setxattr(file_path, b"user.unique_id", unique_id.encode())\n    return unique_id\n\n# Function to get the UUID extended attribute\ndef get_uuid_attribute(file_path):\n    try:\n        unique_id = os.getxattr(file_path, b"user.unique_id")\n        return unique_id.decode()\n    except OSError as e:\n        if e.errno == 61:  # ENODATA - No data available (extended attribute not set)\n            return None\n        raise\n\n# Example usage\nfile_path = "/path/to/your/file"\nuuid_assigned = set_uuid_attribute(file_path)\nprint(f'UUID assigned: {uuid_assigned}')\nuuid_retrieved = get_uuid_attribute(file_path)\nprint(f'UUID retrieved: {uuid_retrieved}')