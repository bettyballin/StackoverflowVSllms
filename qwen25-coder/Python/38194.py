def survival_strategy(prisoner_numbers, boxes):\n    N = len(boxes)\n    max_attempts = N // 2\n    all_survived = True\n    \n    for prisoner in prisoner_numbers:\n        current_box = prisoner - 1  # Convert to 0-based index\n        attempts = 0\n        \n        while attempts < max_attempts:\n            if boxes[current_box] == prisoner:\n                break\n            else:\n                current_box = boxes[current_box] - 1  # Next box based on number found\n                attempts += 1\n        \n        if attempts >= max_attempts:\n            all_survived = False\n            break\n    \n    return all_survived\n\n# Example usage with random permutation of numbers in boxes\nimport random\nprisoner_numbers = list(range(1, 101))\nboxes = list(range(1, 101))\nrandom.shuffle(boxes)\n\nsurvived = survival_strategy(prisoner_numbers, boxes)\nprint("All prisoners survive:", survived)