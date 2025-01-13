import numpy as np\n\ndef angle_distribution(path):\n    angles = np.arctan2(np.diff(path[:, 1]), np.diff(path[:, 0]))\n    return np.histogram(angles, bins=10, range=[-np.pi, np.pi])[0]\n\ndef curvature(path):\n    x, y = path.T\n    dx, dy = np.diff(x), np.diff(y)\n    d2x, d2y = np.diff(dx), np.diff(dy)\n    curvature = (dx * d2y - dy * d2x) / (dx**2 + dy**2)**1.5\n    return curvature