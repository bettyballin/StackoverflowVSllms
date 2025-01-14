# Initial document state\ndocument = "Hello World"\n\n# Operation: insert ' there after 'llo'\noperation1 = ("insert", 5, "'")\n\n# Apply operation and get new document state\nnew_document = document[:operation1[1]] + operation1[2] + document[operation1[1]:]\nprint(new_document)  # Outputs: Hello' World\n\n# Encode the change for transmission (delta)\ndelta = operation1\n\n# On receiving delta apply it to the current local state\nlocal_state = document\nlocal_state = local_state[:delta[1]] + delta[2] + local_state[delta[1]:]\nprint(local_state)  # Outputs: Hello' World