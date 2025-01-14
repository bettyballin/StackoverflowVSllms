import numpy as np\n\ndef average_circular_data(angles_degrees):\n    # Convert angles from degrees to radians\n    angles_radians = np.radians(angles_degrees)\n    \n    # Calculate the average of unit vectors\n    x = np.mean(np.cos(angles_radians))\n    y = np.mean(np.sin(angles_radians))\n    \n    # Convert back to angle in radians and then to degrees\n    mean_angle_radians = np.arctan2(y, x)\n    mean_angle_degrees = np.degrees(mean_angle_radians)\n    \n    # Ensure the angle is between 0 and 360 degrees\n    if mean_angle_degrees < 0:\n        mean_angle_degrees += 360\n    \n    return mean_angle_degrees\n\n# Example usage\nangles = [359, 1]\naverage_angle = average_circular_data(angles)\nprint("Average circular angle:", average_angle)