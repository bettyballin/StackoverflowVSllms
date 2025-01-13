def calculate_totals(entries, currency=None, category=None):\n    # Calculate the total quantity with the given conditions\n    totals = {\n        'quantity': sum(e.quantity for e in entries if (currency is None or e.item_currency == currency) and (category is None or e.category == category)),\n        # Add more totals here if needed, e.g.,\n        # 'amount': sum(e.amount for e in entries if (currency is None or e.item_currency == currency) and (category is None or e.category == category)),\n    }\n    \n    return totals