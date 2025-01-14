from itertools import product\n\ndef generate_combinations(column_data, selected_columns):\n    # Extract only the selected columns' data\n    selected_column_values = [values for name, values in column_data if name in selected_columns]\n    \n    # Generate all possible combinations using Cartesian product\n    return list(product(*selected_column_values))\n\n# Example usage:\ncolumn_definitions = [\n    ('Col1', ['value11', 'value12', 'value13']),\n    ('Col2', ['value21', 'value22']),\n    ('Col3', ['value31', 'value32', 'value33'])\n]\n\n# Choose columns to generate combinations for\nselected_columns = ['Col1', 'Col2']\n\ncombinations = generate_combinations(column_definitions, selected_columns)\nfor combo in combinations:\n    print(combo)