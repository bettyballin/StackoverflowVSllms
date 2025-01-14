import random\n\ndef pickRandElement(elements, p):\n    rand_element = None\n    count = 0\n    for element in elements:\n        if p(element):\n            count += 1\n            # Randomly decide whether to select this element\n            if random.randint(0, count - 1) == 0:  # Note: range is inclusive of both ends in Python's randint\n                rand_element = element\n    return rand_element\n\n# Example usage:\n# elements = [1, 2, 3, 4, 5, 6]\n# p = lambda x: x % 2 == 0  # Property that the number is even\n# print(pickRandElement(elements, p))