from collections import defaultdict\n\n# Sample data\ndata = [\n    {"office": "West", "date": "1/1/2009"},\n    {"office": "West", "date": "1/1/2009"},\n    {"office": "West", "date": "1/2/2009"},\n]\n\n# Dictionary to store unique orders per office and date\nunique_orders = defaultdict(set)\n\nfor entry in data:\n    office = entry["office"]\n    date = entry["date"]\n    # Use a set to ensure uniqueness of dates for each office\n    unique_orders[office].add(date)\n\n# Prepare the report\nreport = []\ntotal_orders = 0\n\nfor office, dates in unique_orders.items():\n    for date in dates:\n        report.append((office, date, 1))\n        total_orders += 1\n\n# Output the report\nprint("Office\tDate\tOrder Count")\nfor entry in report:\n    print(f"{entry[0]}\t{entry[1]}\t{entry[2]} order")\n\nprint("\nTotal orders:", total_orders)