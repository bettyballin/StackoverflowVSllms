def is_majority(nums, candidate):\n    return nums.count(candidate) > len(nums) // 2\n\n# Example usage:\ncandidate = majority_element(arr)\nif is_majority(arr, candidate):\n    print(f"The majority element is {candidate}")\nelse:\n    print("There is no majority element")