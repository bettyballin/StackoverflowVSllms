import csv\n\n# Open the input CSV in read mode\nwith open("PALTemplateData.csv", "r", newline='', encoding='utf-8') as csvfile:\n    # Create a CSV reader object\n    reader = csv.reader(csvfile)\n    \n    # Open the output CSV in write mode\n    with open("PALTemplateDataOUT.csv", "w", newline='', encoding='utf-8') as csvout:\n        # Create a CSV writer object\n        writer = csv.writer(csvout)\n        \n        changed = 0\n        \n        for row in reader:\n            # Perform find and replace on the last column (index -1)\n            modified_row = [element.replace('/?', '?') if i == len(row) - 1 else element \n                            for i, element in enumerate(row)]\n            \n            # Write the modified row to the output file\n            writer.writerow(modified_row)\n            changed += 1\n\nprint('Total URLs changed:', changed)