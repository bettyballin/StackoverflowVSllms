def split_list(input_list, indexes):\n    # Sort the indexes to ensure they are in order\n    indexes.sort()\n\n    # Initialize the result list\n    result = []\n\n    # Initialize the start index\n    start = 0\n\n    # Iterate over the indexes\n    for end in indexes:\n        # Append the slice to the result list\n        result.append(input_list[start:end])\n        # Update the start index\n        start = end\n\n    # Append the remaining slice to the result list\n    result.append(input_list[start:])\n\n    return result\n\n# Example usage\nindexes = [5, 12, 17]\ninput_list = list(range(20))\nprint(split_list(input_list, indexes))