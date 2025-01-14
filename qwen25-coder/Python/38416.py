from fuzzywuzzy import fuzz\n\n# Sample data in the database and from the coupon\ncustomers_db = [\n    {"firstname": "John", "lastname": "Doe", "zip": "12345", "city": "Anytown"},\n    # Add more records as necessary\n]\n\ncoupon_data = {\n    "firstname": "Jhn", \n    "lastname": "Do", \n    "zip": "12345", \n    "city": "Any Town"\n}\n\ndef find_similar_customers(db, coupon):\n    threshold = 80  # Match score threshold\n    possible_matches = []\n\n    for customer in db:\n        name_match = fuzz.partial_ratio(f"{coupon['firstname']} {coupon['lastname']}", f"{customer['firstname']} {customer['lastname']}")\n        zip_match = fuzzywuzzy.fuzz.ratio(coupon['zip'], customer['zip'])\n        city_match = fuzzywuzzy.fuzz.partial_ratio(coupon['city'].replace(" ", "").lower(), customer['city'].replace(" ", "").lower())\n        \n        average_score = (name_match + zip_match + city_match) / 3\n        if average_score >= threshold:\n            possible_matches.append((customer, average_score))\n\n    return possible_matches\n\nmatches = find_similar_customers(customers_db, coupon_data)\nfor match in matches:\n    print(f"Possible Match: {match[0]}, Score: {match[1]}")