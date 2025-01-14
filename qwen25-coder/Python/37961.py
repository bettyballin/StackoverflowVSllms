# Example of loading first names from a CSV file\nimport pandas as pd\n\ndef load_names(file_path):\n    # Load the dataset containing first names\n    df = pd.read_csv(file_path)\n    return df['first_name'].tolist()\n\n# Usage\nfile_path = 'path_to_your_names_dataset.csv'\nnames_list = load_names(file_path)\n\n# Example of checking for typos in a contact database\ndef check_typos(contact_list, reference_names):\n    # Simple typo check by seeing if the name is close enough to any name in the reference list\n    typos = []\n    for name in contact_list:\n        if name not in reference_names and len([n for n in reference_names if n[:3] == name[:3]]) == 0:\n            typos.append(name)\n    return typos\n\n# Example contact list to check\ncontact_list = ['Jhn', 'Smithh', 'Kathrin']\ntypos_found = check_typos(contact_list, names_list)\n\nprint("Possible Typos:", typos_found)