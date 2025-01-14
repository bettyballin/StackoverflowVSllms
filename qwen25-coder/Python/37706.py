import csv\nfrom itertools import tee\n\n# Function to check if there are more rows in the iterator\ndef has_next(it):\n    try:\n        next(it)\n        return True\n    except StopIteration:\n        return False\n\n# Open file and create a reader object\nwith open('somefile.csv', 'r') as csvfile:\n    reader = csv.reader(csvfile, delimiter='|', quotechar=None)\n    \n    header = next(reader)  # Read the header row\n    \n    # Create two independent iterators\n    it1, it2 = tee(reader)\n    \n    for line_num, row in enumerate(it1):\n        if has_next(it2):  # Check if there's a next row\n            print(f"Processing row {line_num + 1}: {row}")\n            assert len(row) == len(header), f"Row {line_num + 1} does not match header length"\n        else:\n            print("This is the last row:", row)\n            # Handle the last row, e.g., by adjusting for the missing delimiters