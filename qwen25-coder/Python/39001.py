import bisect\n\n# Method 1: Insert each item with binary search\ndef insert_sorted(lst, items):\n    for item in items:\n        bisect.insort(lst, item)\n    return lst\n\n# Method 2: Add all items then sort\ndef append_and_sort(existing_list, new_items):\n    existing_list.extend(new_items)\n    existing_list.sort()\n    return existing_list\n\n# Example usage\nsorted_list = [1, 3, 4, 7, 9]\nnew_items = [5, 6, 2, 8]\n\nsorted_with_insert = insert_sorted(sorted_list.copy(), new_items)\nsorted_with_batch = append_and_sort(sorted_list.copy(), new_items)\n\nprint("Sorted by inserting:", sorted_with_insert)\nprint("Sorted by batching and sorting:", sorted_with_batch)