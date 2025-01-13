import random\n\n# Define the grammar\ngrammar = {\n    'S': ['${NP} ${VP}', '${S} and ${S}', '${S}, after which ${S}'],\n    'NP': ['the ${N}', 'the ${A} ${N}', 'the ${A} ${A} ${N}'],\n    'VP': ['${V} ${NP}'],\n    'N': ['dog', 'fish', 'bird', 'wizard'],\n    'V': ['kicks', 'meets', 'marries'],\n    'A': ['red', 'striped', 'spotted']\n}\n\ndef produce_sentence(n, symbol='S'):\n    sentence = ''\n    terminals = 0\n\n    # Base case: if the symbol is a terminal, return it\n    if symbol in ['N', 'V', 'A']:\n        sentence = random.choice(grammar[symbol])\n        terminals = 1\n\n    # Recursive case: expand the symbol\n    else:\n        production = random.choice(grammar[symbol])\n        for token in production.split():\n            if token.startswith('${'):\n                token = token[2:-1]  # Remove '${' and '}'\n                sub_sentence, sub_terminals = produce_sentence(n - terminals, token)\n                sentence += sub_sentence + ' '\n                terminals += sub_terminals\n            else:\n                sentence += token + ' '\n\n    # If the number of terminals exceeds the target, truncate the sentence\n    if terminals > n:\n        sentence = sentence[:sentence.rfind(' ')]\n\n    return sentence.strip(), terminals\n\n# Example usage:\nn = 5\nsentence, _ = produce_sentence(n)\nprint(sentence)