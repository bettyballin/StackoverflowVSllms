def sort(l):\n    while not sorted(l):  # O(n) check if list is sorted\n        random.shuffle(l)  # O(n) shuffle operation\n        # Expected number of times the loop runs: n!