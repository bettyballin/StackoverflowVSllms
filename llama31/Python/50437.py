# Insecure code example (don't try this at home!)\ndef process_user_input(input_data):\n    # Assume input_data is sanitized (it's not)\n    command = "SELECT * FROM users WHERE name = '" + input_data + "'"\n    execute_query(command)