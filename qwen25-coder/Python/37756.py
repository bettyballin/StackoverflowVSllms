jargon = open("jargonFile.txt", "r")\nwhile True:\n    searchPhrase = raw_input("Enter the search phrase: ")\n    if searchPhrase == "":\n        break\n\n    # Reset the file pointer to the beginning of the file for each new search\n    jargon.seek(0)\n\n    found = False\n    line_number = 1\n    for line in jargon:\n        result = line.find(searchPhrase)\n        if result != -1:\n            print(f"Found '{searchPhrase}' at line {line_number}, position {result}.")\n            found = True\n        line_number += 1\n\n    if not found:\n        print(f"Cannot find this term.")\n\njargon.close()