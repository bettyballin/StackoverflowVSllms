from math import gcd\nfrom functools import reduce\n\n# Function to calculate LCM\ndef lcm(a, b):\n    return abs(a*b) // gcd(a, b)\n\n# Function to calculate LCM of multiple numbers\ndef lcm_multiple(numbers):\n    return reduce(lcm, numbers)\n\n# Define the task intervals in hours\ntasks = {\n    "1A": 500,\n    "2A": 1000,\n    "3A": 1500,\n    # Add more tasks here if needed\n}\n\n# Function to find the next set of tasks\ndef next_tasks(last_time):\n    time_intervals = list(tasks.values())\n    lcm_interval = lcm_multiple(time_intervals)\n    \n    next_time = last_time + 1\n    while next_time <= last_time + lcm_interval:\n        due_tasks = [task for task, interval in tasks.items() if next_time % interval == 0]\n        if due_tasks:\n            return next_time, due_tasks\n        next_time += 1\n    return None\n\n# Example usage\nlast_time = 5000  # Example last time\nnext_time, due_tasks = next_tasks(last_time)\nprint(f"Next time: {next_time}, Due tasks: {due_tasks}")