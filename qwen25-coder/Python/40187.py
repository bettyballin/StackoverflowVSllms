# Example: Simple Dictionary-Based Compression Algorithm\n\ndef compress(input_string):\n    # Initialize the dictionary with all possible single-character entries.\n    dict_size = 256\n    dictionary = {chr(i): i for i in range(dict_size)}\n\n    w = ""\n    compressed_data = []\n\n    for c in input_string:\n        wc = w + c\n        if wc in dictionary:\n            w = wc\n        else:\n            compressed_data.append(dictionary[w])\n            # Add wc to the dictionary.\n            dictionary[wc] = dict_size\n            dict_size += 1\n            w = c\n\n    # Output the code for w.\n    if w:\n        compressed_data.append(dictionary[w])\n\n    return compressed_data\n\ndef decompress(compressed_data):\n    # Build the dictionary.\n    dict_size = 256\n    dictionary = {i: chr(i) for i in range(dict_size)}\n\n    # Use first character of input as starting point for decoding.\n    w = result = previous_code = str(chr(compressed_data.pop(0)))\n    for k in compressed_data:\n        if k in dictionary:\n            entry = dictionary[k]\n        elif k == dict_size:\n            entry = w + w[0]\n        else:\n            raise ValueError('Bad compressed k: %s' % k)\n        result += entry\n\n        # Add w+entry[0] to the dictionary.\n        dictionary[dict_size] = w + entry[0]\n        dict_size += 1\n\n        w = entry\n    return result\n\n# Example usage:\noriginal_text = "TOBEORNOTTOBETOBEORTOBEORNOT"\ncompressed = compress(original_text)\ndecompressed = decompress(compressed)\n\nprint("Original:", original_text)\nprint("Compressed:", compressed)\nprint("Decompressed:", decompressed)