keys = ['name', 'age']\nvalues = ['Monty', 42, 'Matt', 28, 'Frank', 33]\n\n# Create a list of dictionaries\nresult = [dict(zip(keys, values[i:i+len(keys)])) for i in range(0, len(values), len(keys))]\n\nprint(result)