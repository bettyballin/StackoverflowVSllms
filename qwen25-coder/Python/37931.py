fail = [\n    ['da39a3ee5e6b4b0d3255bfef95601890afd80709', 'ron\\b\\include', 'Test.java'],\n    ['b5cc17d3a35877ca8b76f0b2e07497039c250696', 'ron\\c', 'apa1.txt'],\n    ['95d1543adea47e88923c3d4ad56e9f65c2b40c76', 'ron\\c', 'knark.txt'],\n    ['da39a3ee5e6b4b0d3255bfef95601890afd80709', 'ron\\d', 'Sourcecheck.py'],\n    ['da39a3ee5e6b4b0d3255bfef95601890afd80709', 'ron\\a\\include', 'svin.txt'],\n    ['b5cc17d3a35877ca8b76f0b2e07497039c250696', 'ron\\a', 'apa2.txt'],\n    ['95d1543adea47e88923c3d4ad56e9f65c2b40c76', 'ron\\c', 'apa.txt']\n]\n\n# Dictionary to store occurrences\noccurrences = {}\n\n# Classify entries based on sha1 and directory\nfor entry in fail:\n    sha1, directory, _ = entry\n    key = (sha1, directory)\n    \n    if key not in occurrences:\n        occurrences[key] = []\n    \n    occurrences[key].append(entry)\n\nduplicate = []\ndiff = []\n\n# Separate into duplicate and diff lists based on the number of entries in each group\nfor entries in occurrences.values():\n    if len(entries) > 1:\n        # All these have the same sha1 and directory, so they are duplicates within that directory\n        duplicate.extend(entries)\n    elif len(occurrences[(entries[0][0], entries[0][1])]) == 1:\n        # Check if there are any other files with this sha1 in a different directory\n        for k, v in occurrences.items():\n            if k[0] == entries[0][0] and k[1] != entries[0][1]:\n                diff.extend(entries)\n\nprint("Duplicate:")\nfor d in duplicate:\n    print(d)\n\nprint("\nDiff:")\nfor d in diff:\n    print(d)