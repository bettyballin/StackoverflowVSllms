import numpy as np\nfrom scipy.stats import expon\nimport matplotlib.pyplot as plt\n\n# Example event durations data (replace this with actual histogram bin values)\ndata = np.random.exponential(scale=1, size=1000)\n\n# Fit the exponential distribution parameters\nloc, scale = expon.fit(data)\n\n# Print the fitted parameters\nprint("Fitted Parameters: loc =", loc, ", scale =", scale)