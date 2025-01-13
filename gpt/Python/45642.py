from fuzzywuzzy import fuzz\n\n   def is_duplicate(address1, address2):\n       return fuzz.ratio(address1.lower(), address2.lower()) > 85\n\n   # Example usage\n   address1 = 'Quellenstrasse 66/11'\n   address2 = 'Quellenstr. 66a-11'\n   if is_duplicate(address1, address2):\n       print("Duplicate address detected")