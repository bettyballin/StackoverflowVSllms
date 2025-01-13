def exponential_moving_average(values, alpha, sample_size):\n    ema = values[0]\n    for i in range(1, sample_size):\n        ema = (values[i] * alpha) + (ema * (1 - alpha))\n    return ema\n\n# Example usage:\nvalues = [10, 12, 11, 13, 15, 14, 16, 18, 17, 19]\nalpha = 0.5  # adjust this value to control the smoothing factor\nsample_size = 10\n\nema = exponential_moving_average(values, alpha, sample_size)\nprint(ema)