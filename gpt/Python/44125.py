def determine_columns(count):\n    if count <= 15:\n        return 1\n    elif count <= 30:\n        return 2\n    elif count <= 45:\n        return 3\n    elif count <= 60:\n        return 4\n    elif count <= 75:\n        return 5\n    elif count <= 90:\n        return 6\n    elif count <= 105:\n        return 7\n    else:\n        return 8\n\ndef split_into_columns(items, columns):\n    result = []\n    rows = (len(items) + columns - 1) // columns  # Calculate the number of rows needed\n    for i in range(rows):\n        row = items[i::rows]\n        result.append(row)\n    return result\n\n# Example usage\nitems = list(range(1, 51))  # List of 50 items\ncolumns = determine_columns(len(items))\ncolumns_data = split_into_columns(items, columns)\n\n# Displaying the result\nfor row in columns_data:\n    print("\t".join(map(str, row)))