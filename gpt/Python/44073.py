def get_price(item_price, quantity, client_age, hour_of_day):\n    discount = 0\n    \n    if hour_of_day > 18:\n        discount += percent_of(5, item_price)\n    \n    if quantity > 10:\n        discount += percent_of(5, item_price)\n    \n    if client_age > 60 or client_age < 18:\n        discount += percent_of(5, item_price)\n    \n    final_price = item_price - discount\n    return final_price\n\ndef percent_of(percent, total):\n    return (percent / 100) * total\n\n# Example usage\nitem_price = 100\nquantity = 11\nclient_age = 65\nhour_of_day = 19\n\nprice = get_price(item_price, quantity, client_age, hour_of_day)\nprint(f"The final price is: {price}")