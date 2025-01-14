def moving_average(data, window_size):\n    return np.convolve(data, np.ones(window_size)/window_size, mode='valid')\n\n# Example usage:\nsmoothed_points = moving_average(filtered_points, window_size=3)\nprint(smoothed_points)