from fuzzywuzzy import process\n\n# List of valid words\nvalid_words = ["water", "quarter", "beer", "beet", "hell", "hello", "aardvark"]\n\n# User input\nuser_input = "qater"  # Example input with a typo\n\n# Get the best match\nbest_match, score = process.extractOne(user_input, valid_words)\n\nprint(f"The closest match to '{user_input}' is '{best_match}' with a confidence score of {score}%.")