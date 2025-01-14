from difflib import get_close_matches\n\n# List of airport names (this should be your complete list)\nairport_names = [\n    "New York-JFK",\n    "Los Angeles-LAX",\n    "Chicago-O'Hare",\n    "Houston-Intercontinental",\n    "Phoenix-Sky Harbor",\n    # Add more airports as needed\n]\n\ndef suggest_airports(user_input, airport_list=airport_names):\n    # Get close matches with a ratio threshold (e.g., 0.6)\n    suggestions = get_close_matches(user_input, airport_list, n=5, cutoff=0.6)\n    return suggestions\n\n# Example usage\nuser_entry = "Nw York-JFK"  # Simulate a user's misspelled input\nsuggestions = suggest_airports(user_entry)\n\nprint("Did you mean any of these?")\nfor suggestion in suggestions:\n    print(suggestion)