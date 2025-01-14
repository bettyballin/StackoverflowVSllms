def get_card_type(card_number):\n    # Convert the card number to string for slicing\n    card_number = str(card_number)\n    \n    if len(card_number) >= 2:\n        start_two_digits = int(card_number[:2])\n        start_four_digits = int(card_number[:4])\n        \n        # Check conditions based on IIN ranges\n        if 3528 <= start_four_digits <= 3589 and len(card_number) == 16:\n            return "JCB"\n        elif (start_two_digits in [34, 37] and len(card_number) == 15):\n            return "American Express"\n        elif (51 <= start_two_digits <= 55 and len(card_number) == 16):\n            return "MasterCard"\n        elif card_number[0] == '4' and (len(card_number) in [13, 16]):\n            return "Visa"\n        elif (start_four_digits == 6011 or \n              622126 <= start_six_digits <= 622925 or \n              644 <= start_three_digits <= 649 or\n              start_two_digits in [65, 67] and len(card_number) == 16):\n            return "Discover"\n    \n    return "Unknown"\n\n# Example usage\ncard_number = "4111111111111111"  # Visa card number for testing\nprint("Card Type:", get_card_type(card_number))