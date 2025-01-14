def simplify_debts(debts):\n    # Calculate net balance for each person\n    balance = {}\n    for lender, borrower, amount in debts:\n        if lender not in balance:\n            balance[lender] = 0\n        if borrower not in balance:\n            balance[borrower] = 0\n        balance[lender] -= amount\n        balance[borrower] += amount\n\n    # Sort people by their net balance (creditors first)\n    creditors = sorted([person for person, bal in balance.items() if bal > 0], key=balance.get, reverse=True)\n    debtors = sorted([person for person, bal in balance.items() if bal < 0])\n\n    simplified_debts = []\n    while creditors and debtors:\n        creditor = creditors.pop(0)\n        debtor = debtors.pop(0)\n\n        amount = min(-balance[debtor], balance[creditor])\n        \n        # Add the new transaction\n        simplified_debts.append((creditor, debtor, amount))\n\n        # Adjust balances\n        balance[creditor] -= amount\n        balance[debtor] += amount\n\n        if balance[creditor] > 0:\n            creditors.insert(0, creditor)\n        elif balance[debtor] < 0:\n            debtors.insert(0, debtor)\n\n    return simplified_debts\n\n# Example usage\ndebts = [('Mike', 'John', 100), ('John', 'Rachel', 200), ('Mike', 'Rachel', 400)]\nprint(simplify_debts(debts))