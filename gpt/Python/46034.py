import uuid\nimport hashlib\nimport base64\nimport mysql.connector\n\ndef generate_unique_key(identifier):\n    # Convert the identifier to a string if it's not already\n    identifier_str = str(identifier)\n    \n    # Create a SHA-256 hash of the identifier\n    hash_object = hashlib.sha256(identifier_str.encode())\n    hash_digest = hash_object.digest()\n    \n    # Encode the hash digest using URL-safe base64 encoding\n    unique_key = base64.urlsafe_b64encode(hash_digest).rstrip(b'=').decode('ascii')\n    \n    return unique_key[:8]  # Return only the first 8 characters to shorten the URL\n\ndef insert_record_and_generate_url(data):\n    # Connect to the MySQL database\n    cnx = mysql.connector.connect(user='your_user', password='your_password',\n                                  host='your_host', database='your_database')\n    cursor = cnx.cursor()\n    \n    # Insert the record into the database\n    add_record = ("INSERT INTO your_table (data_column) VALUES (%s)")\n    cursor.execute(add_record, (data,))\n    \n    # Get the auto-incremented ID of the newly inserted record\n    record_id = cursor.lastrowid\n    \n    # Generate the unique key for the URL\n    unique_key = generate_unique_key(record_id)\n    \n    # Update the record with the unique URL key\n    update_record = ("UPDATE your_table SET url_key = %s WHERE id = %s")\n    cursor.execute(update_record, (unique_key, record_id))\n    \n    # Commit the transaction and close the connection\n    cnx.commit()\n    cursor.close()\n    cnx.close()\n    \n    # Generate the full URL\n    unique_url = f"http://example.com/{unique_key}"\n    return unique_url\n\n# Example usage\ndata = "Sample data for the record"\nunique_url = insert_record_and_generate_url(data)\nprint("Generated URL:", unique_url)