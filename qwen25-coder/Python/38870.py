import random\n\ndef distribute_control_data(real_data, control_data):\n    num_real = len(real_data)\n    num_control = len(control_data)\n    average_interval = num_real / (num_control + 1) if num_control > 0 else num_real\n    \n    # Generate indices for insertion\n    indices = []\n    for _ in range(num_control):\n        # Random offset around the average interval\n        offset = random.uniform(average_interval * 0.5, average_interval * 1.5)\n        index = prev_index + offset if indices else offset\n        indices.append(index)\n    \n    # Ensure indices are within bounds and unique by rounding and removing duplicates\n    indices = list(set(round(idx) for idx in indices))[:num_control]\n    indices = [min(max(0, idx), num_real) for idx in indices]  # Clamp indices to data bounds\n    \n    # Sort the insertion points to ensure correct order\n    indices.sort()\n    \n    # Insert control data into real data based on calculated indices\n    result = []\n    last_index = 0\n    for i, index in enumerate(indices):\n        result.extend(real_data[last_index:int(index)])\n        result.append(control_data[i])\n        last_index = int(index)\n    result.extend(real_data[last_index:])  # Add remaining real data\n    \n    return result\n\n# Example usage\nreal_data = list(range(3000))  # Simulating 3000 rows of real data\ncontrol_data = ['C' + str(i) for i in range(20)]  # Simulating 20 rows of control data\n\ndistributed_data = distribute_control_data(real_data, control_data)