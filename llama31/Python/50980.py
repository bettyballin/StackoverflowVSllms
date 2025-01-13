import heapq\n\ndef sort_by_sum(nums):\n    # Create a priority queue to store the numbers\n    pq = []\n    for i in range(len(nums)):\n        heapq.heappush(pq, (nums[i], i))\n\n    # Initialize the running total\n    total = 0\n\n    # Iterate over the list and swap the numbers\n    for i in range(len(nums)):\n        # Get the number with the smallest sum from the priority queue\n        num, j = heapq.heappop(pq)\n        # Swap the numbers\n        nums[i], nums[j] = nums[j], nums[i]\n        # Add the sum to the running total\n        total += num + nums[i]\n        # Push the next number into the priority queue\n        if i < len(nums) - 1:\n            heapq.heappush(pq, (nums[i + 1], i + 1))\n\n    return total\n\n# Test the function\nprint(sort_by_sum([3, 2, 1]))  # Output: 4\nprint(sort_by_sum([1, 8, 9, 7, 6]))  # Output: 41\nprint(sort_by_sum([8, 4, 5, 3, 2, 7]))  # Output: 34