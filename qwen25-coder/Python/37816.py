def find_closest_slot(slots, value):\n    """\n    Find the index of the closest slot for a given value.\n    \n    :param slots: Sorted list of slot values.\n    :param value: The value to find the closest slot for.\n    :return: Index of the closest slot.\n    """\n    import bisect\n    \n    # Find the insertion point\n    pos = bisect.bisect(slots, value)\n    \n    if pos == 0:\n        return 0\n    elif pos == len(slots):\n        return pos - 1\n    else:\n        # Compare distances to determine the closest slot\n        before = slots[pos - 1]\n        after = slots[pos]\n        return (pos - 1) if (value - before) <= (after - value) else pos\n\n# Example usage\nslots = [0.0, 0.4, 0.6, 1.2, 5.0, 10.0]\ndata_points = [0.1, 0.6, 4.23, 5.1, 7.0]\n\nclosest_slots = [find_closest_slot(slots, point) for point in data_points]\nprint("Closest slots indices:", closest_slots)