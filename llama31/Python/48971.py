def similarity_score(input_string):\n    reference_string = "your_reference_string_here"\n    distance = levenshtein_distance(input_string, reference_string)\n    return 1 - (distance / max(len(input_string), len(reference_string)))\n\n# Example usage:\ninput_string = "example_input"\nscore = similarity_score(input_string)\nprint(score)  # Output: a value between 0 and 1