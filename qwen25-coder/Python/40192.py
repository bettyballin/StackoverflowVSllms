def determine_columns(item_count):\n    # Set maximum number of columns allowed\n    max_columns = 8\n    \n    if item_count <= 15:\n        return 1\n    elif item_count > 100:\n        return max_columns\n    else:\n        # Calculate the optimal number of columns\n        for columns in range(2, max_columns + 1):\n            rows_per_column = -(-item_count // columns)  # Ceiling division\n            if rows_per_column <= columns:\n                return columns\n        return max_columns\n\ndef split_into_columns(item_list):\n    item_count = len(item_list)\n    column_count = determine_columns(item_count)\n    rows = [[] for _ in range(column_count)]\n    \n    for index, item in enumerate(item_list):\n        rows[index % column_count].append(item)\n    \n    return rows\n\n# Example usage\nitems = list(range(1, 52))  # Example list with 51 items\ncolumns = split_into_columns(items)\n\nfor row in columns:\n    print("\t".join(map(str, row)))