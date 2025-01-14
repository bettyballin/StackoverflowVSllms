import random\n\n# Define your clients with their respective weights based on the requirements.\n# The weights here are hypothetical; you'll need to adjust them based on actual business logic.\nclients = [\n    {'id': 1, 'budget': 10000, 'goal_impressions': 10000, 'duration_days': 10, 'weight': 3},\n    {'id': 2, 'budget': 100, 'goal_impressions': 1000, 'weight': 1},\n    {'id': 3, 'budget': 5000, 'goal_clicks': 1000, 'goal_impressions': 10000, 'weight': 2}\n]\n\n# Calculate total weight\ntotal_weight = sum(client['weight'] for client in clients)\n\ndef select_banner():\n    # Randomly determine the banner to show based on weights\n    rand_num = random.uniform(0, total_weight)\n    cumulative_weight = 0\n\n    for client in clients:\n        cumulative_weight += client['weight']\n        if rand_num <= cumulative_weight:\n            return client['id']\n\n# Simulate serving a banner for each page request\nfor _ in range(25):  # Example: serve 25 ads\n    selected_banner_id = select_banner()\n    print(f"Serving Banner ID: {selected_banner_id}")