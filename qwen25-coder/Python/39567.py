data = [\n    {"key1": "value1", "key2": "value2"},\n    {"key1": "value4", "key2": "value5"},\n    {"key1": "value1", "key2": "value8"}\n]\n\n# Define the value you want to filter by\ntarget_value = "value1"\n\n# Create a list to hold dictionaries that match the criteria\nsubdata = [datadict for datadict in data if datadict.get("key1") == target_value]\n\nprint(subdata)