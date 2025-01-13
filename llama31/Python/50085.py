def hide_data(text, data):\n    # Convert data to hexadecimal\n    hex_data = hex(data)[2:]\n    \n    # Replace each hexadecimal digit with a corresponding word\n    words = {\n        '0': 'zero',\n        '1': 'one',\n        '2': 'two',\n        '3': 'three',\n        # ...\n    }\n    \n    hidden_text = text\n    for i, char in enumerate(hex_data):\n        word = words[char]\n        hidden_text = hidden_text.replace(f'the {i+1} ', f'the {word} ')\n    \n    return hidden_text\n\ntext = "The cat sat on the dog and was happy."\ndata = 123\nhidden_text = hide_data(text, data)\nprint(hidden_text)