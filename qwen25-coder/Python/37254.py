def find_ranges(test_number, ranges):\n    # Sort ranges based on their start value\n    ranges.sort(key=lambda x: x[0])\n    \n    from bisect import bisect_left\n    \n    # Find the index where test_number can be inserted to maintain sorted order of start points\n    idx = bisect_left(ranges, (test_number,))\n    \n    # Check if the found range includes the test number\n    if idx < len(ranges) and ranges[idx][0] <= test_number <= ranges[idx][1]:\n        return [ranges[idx]]\n    \n    return []\n\n# Example usage:\nranges = [(0, 5), (10, 20), (7, 13), (-1, 37)]\ntest_number = 8\nresult = find_ranges(test_number, ranges)\nprint("Test number", test_number, "belongs to the sets:", result)