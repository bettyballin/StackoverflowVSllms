import scipy.stats as stats\nimport numpy as np\n\n# Define the probability P and the bounds (-a, a)\nP = 0.95  # Example: 95% of the distribution within [-a, a]\na = stats.norm.ppf((1 + P) / 2)  # Find the critical value a for the given P\n\nmean = 0\nstd_deviation = a  # For a standard normal distribution, mean = 0 and std_dev = 1\n\nprint(f"Standard Deviation: {std_deviation}")