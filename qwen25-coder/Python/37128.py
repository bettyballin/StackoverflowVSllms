# List of dictionaries\npeople = [{'name': 'Homer', 'age': 39}, {'name': 'Bart', 'age': 10}]\n\n# Sort by the 'name' key\nsorted_people = sorted(people, key=lambda person: person['name'])\n\n# Output the sorted list\nprint(sorted_people)