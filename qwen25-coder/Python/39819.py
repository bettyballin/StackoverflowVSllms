import random\nimport string\nfrom google.appengine.api import memcache\n\ndef generate_random_string(length=6):\n    # Generate and return a random alphanumeric string of specified length\n    characters = string.ascii_letters + string.digits\n    return ''.join(random.choice(characters) for _ in range(length))\n\ndef check_and_store_to_memcache():\n    while True:\n        randomstring = generate_random_string()\n        if not memcache.get(randomstring):  # Check if the generated string is already a key in memcache\n            memcache.add(randomstring, 'some_value')  # Store it with an example value\n            break  # Exit the loop once a unique key is found and stored