import random\nimport hashlib\n\n# Simulate a large index of words\nindex = [f"word_{i}" for i in range(1000000)]\n\n# Take a random sample of the index (e.g., 1%)\nsample_size = int(0.01 * len(index))\nsample = random.sample(index, sample_size)\n\n# Create a hash table to count unique hash values\nhash_table = {}\nfor word in sample:\n    hash_value = hashlib.sha256(word.encode()).hexdigest()\n    if hash_value not in hash_table:\n        hash_table[hash_value] = 1\n    else:\n        hash_table[hash_value] += 1\n\n# Estimate the total number of results based on the sample count\nestimated_count = len(hash_table) * (len(index) / sample_size)\nprint(f"Estimated count: {estimated_count}")