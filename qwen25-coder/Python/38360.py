import hashlib\n\n# Example of MD5 collision where A and B collide but appending C does not\nA = b'anything here'\nB = b'different string here'\nC = b'something appended'\n\n# Check original collision (this is just a placeholder; actual A, B would be specific known collisions)\nprint("MD5(A):", hashlib.md5(A).hexdigest())\nprint("MD5(B):", hashlib.md5(B).hexdigest())\n\n# Appending same data\nA_C = A + C\nB_C = B + C\n\n# Check new hashes\nprint("MD5(A+C):", hashlib.md5(A_C).hexdigest())\nprint("MD5(B+C):", hashlib.md5(B_C).hexdigest())\n\n# SHA-256 example (appending changes the hash as expected)\nA_sha = b'anything here'\nB_sha = b'different string here'\n\n# Check SHA-256 collision likelihood with appended data\nA_SHA_C = A_sha + C\nB_SHA_C = B_sha + C\n\nprint("SHA-256(A+C):", hashlib.sha256(A_SHA_C).hexdigest())\nprint("SHA-256(B+C):", hashlib.sha256(B_SHA_C).hexdigest())