import re\n\ndef singularize(word):\n    # Define a set of rules and exceptions for plural to singular conversion\n    exceptions = {\n        'men': 'man',\n        'women': 'woman',\n        'children': 'child',\n        'teeth': 'tooth',\n        'feet': 'foot',\n        'people': 'person',\n        'leaves': 'leaf',\n        'mice': 'mouse',\n        'geese': 'goose',\n        'halves': 'half',\n        'knives': 'knife',\n        'wives': 'wife',\n        'lives': 'life',\n        'elves': 'elf',\n        'loaves': 'loaf',\n        'potatoes': 'potato',\n        'tomatoes': 'tomato',\n        'cacti': 'cactus',\n        'foci': 'focus',\n        'fungi': 'fungus',\n        'nuclei': 'nucleus',\n        'syllabi': 'syllabus',\n        'analyses': 'analysis',\n        'diagnoses': 'diagnosis',\n        'oases': 'oasis',\n        'theses': 'thesis',\n        'crises': 'crisis',\n        'phenomena': 'phenomenon',\n        'criteria': 'criterion',\n        'data': 'datum'\n    }\n    \n    # Check for exceptions first\n    if word in exceptions:\n        return exceptions[word]\n\n    # Rules for regular plural forms\n    rules = [\n        (r'ies$', 'y'),\n        (r'ves$', 'f'),\n        (r'xes$', 'x'),\n        (r'ches$', 'ch'),\n        (r'shes$', 'sh'),\n        (r'oes$', 'o'),\n        (r's$', '')\n    ]\n\n    # Apply each rule iteratively\n    for pattern, replacement in rules:\n        if re.search(pattern, word):\n            return re.sub(pattern, replacement, word)\n\n    # Return the word itself if no rules match\n    return word\n\n# Test cases\ntest_words = ["buses", "boxes", "batches", "potatoes", "lives", "mice", "children", "analyses", "crises"]\nsingular_words = [singularize(word) for word in test_words]\nprint(singular_words)