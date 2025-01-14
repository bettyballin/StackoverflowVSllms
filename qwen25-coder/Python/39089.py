import re\n\ndef parse_user_data(data_string):\n    # Define a pattern to match key-value pairs in the format "key: value"\n    pattern = r'(\w+):\s*([^:\n]+)'\n    \n    # Use regex findall to extract all matches into a list of tuples (key, value)\n    matches = re.findall(pattern, data_string)\n    \n    # Convert the list of tuples into a dictionary\n    user_data = {key: value.strip() for key, value in matches}\n    \n    return user_data\n\n# Example usage\ndata_string = "userAccountName: abc userCompany: xyz userEmail: a@xyz.com userAddress1: 123 St userAddress2: Apt 4B userAddress3: userTown: Springfield ..."\nparsed_data = parse_user_data(data_string)\nprint(parsed_data)