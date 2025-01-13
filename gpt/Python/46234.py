import pandas as pd\nimport re\n\n# Read the spreadsheet\ninput_file = 'your_spreadsheet.xlsx'\ndf = pd.read_excel(input_file)\n\n# Define function to clean up data\ndef clean_data(text):\n    if isinstance(text, str):\n        text = re.sub(r"['\"]", "", text)  # Remove single and double quotes\n        text = re.sub(r"<.*?>", "", text)  # Remove HTML tags\n        return text\n    return text\n\n# Apply the clean_data function to all elements in the dataframe\ndf = df.applymap(clean_data)\n\n# Save the cleaned dataframe to a new spreadsheet\noutput_file = 'cleaned_spreadsheet.xlsx'\ndf.to_excel(output_file, index=False)