import hashlib\n\ndata = "Hello, World!"\nhash_value = hashlib.sha1(data.encode()).hexdigest()\nprint(hash_value)