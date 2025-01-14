import random\n\ndef generate_non_overlapping_circles(num_circles, radius, width, height):\n    circles = []\n    \n    for _ in range(num_circles):\n        found_location = False\n        \n        while not found_location:\n            # Generate a random position within the bounds of the region minus circle radius\n            x = random.uniform(radius, width - radius)\n            y = random.uniform(radius, height - radius)\n            \n            # Check for overlap with existing circles\n            overlap = False\n            for cx, cy in circles:\n                distance_sq = (x - cx) ** 2 + (y - cy) ** 2\n                if distance_sq < (2 * radius) ** 2:  # Distance should be more than 2 radii squared\n                    overlap = True\n                    break\n            \n            if not overlap:\n                circles.append((x, y))\n                found_location = True\n    \n    return circles\n\n# Example usage:\nnum_circles = 10\nradius = 5\nwidth = 100\nheight = 100\n\ncircles = generate_non_overlapping_circles(num_circles, radius, width, height)\nprint(circles)