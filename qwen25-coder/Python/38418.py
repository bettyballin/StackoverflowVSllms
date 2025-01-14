def settle_expenses(transactions):\n    # Calculate net balance for each person\n    balances = {}\n    for payer, amount in transactions:\n        if payer not in balances:\n            balances[payer] = 0\n        balances[payer] += amount\n\n    # Separate into debtors and creditors\n    debtors = []\n    creditors = []\n    for person, balance in balances.items():\n        if balance < 0:\n            debtors.append((person, -balance))\n        elif balance > 0:\n            creditors.append((person, balance))\n\n    # Sort them to optimize the transaction count (optional)\n    debtors.sort(key=lambda x: x[1])\n    creditors.sort(key=lambda x: x[1], reverse=True)\n\n    transactions_needed = []\n\n    # Settle debts\n    while debtors and creditors:\n        debtor = debtors.pop(0)\n        creditor = creditors.pop(0)\n\n        if debtor[1] == creditor[1]:  # Exact match\n            transactions_needed.append((debtor[0], creditor[0], debtor[1]))\n        elif debtor[1] < creditor[1]:  # Debtor pays off part of the debt\n            transactions_needed.append((debtor[0], creditor[0], debtor[1]))\n            creditors.insert(0, (creditor[0], creditor[1] - debtor[1]))  # Remaining debt\n        else:  # Creditor is paid off and there's some remaining debt from the debtor\n            transactions_needed.append((debtor[0], creditor[0], creditor[1]))\n            debtors.insert(0, (debtor[0], debtor[1] - creditor[1]))  # Remaining debt\n\n    return transactions_needed\n\n# Example usage\ntransactions = [\n    ('A', -400),  # A spent 400\n    ('B', -1000), # B spent 1000\n    ('C', -100)   # C spent 100\n]\n\nsettlements = settle_expenses(transactions)\nfor settlement in settlements:\n    print(f"{settlement[0]} needs to give {settlement[2]} to {settlement[1]}")