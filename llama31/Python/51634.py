import numpy as np\n\ndef byte_distribution(data):\n    return np.histogram(data, bins=256, density=True)