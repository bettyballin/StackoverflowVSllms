def calculate_bidding_price(total_cost):\n    # Define the function to calculate total cost from bidding price\n    def compute_total_from_bid(bidding_price):\n        usage_price = max(min(0.1 * bidding_price, 50), 10)\n        seller_price = 0.02 * bidding_price\n        \n        if bidding_price <= 500:\n            added_price = 5\n        elif 501 <= bidding_price <= 1000:\n            added_price = 10\n        elif 1001 <= bidding_price <= 3000:\n            added_price = 15\n        else:\n            added_price = 20\n        \n        storing_cost = 100\n        \n        return usage_price + seller_price + added_price + storing_cost + bidding_price\n\n    # Start guessing from a reasonable initial value\n    low, high = 1000, 3000  # Adjust these bounds based on your estimates\n    tolerance = 0.01  # Tolerance level for the bid price calculation\n    \n    while low <= high:\n        mid = (low + high) / 2\n        total_calculated = compute_total_from_bid(mid)\n        \n        if abs(total_calculated - total_cost) < tolerance:\n            return round(mid, 2)  # Return the bidding price rounded to 2 decimals\n        \n        if total_calculated < total_cost:\n            low = mid + 1\n        else:\n            high = mid - 1\n    \n    return None  # In case no valid bid is found within the range\n\n# Example usage\ntotal_price = 2000\nbidding_price = calculate_bidding_price(total_price)\nprint(f"Bidding price for a total cost of ${total_price} is approximately: ${bidding_price}")