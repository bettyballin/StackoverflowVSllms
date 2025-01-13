import numpy as np\nfrom scipy.constants import G\n\n# Constants\nM_sun = 1.989e30  # kg\nM_earth = 5.972e24  # kg\nr0 = 149.6e9  # m (average distance between Earth and Sun)\n\n# Time parameters\ndt = 86400  # s (1 day)\nt_end = 365 * dt  # s (1 year)\n\n# Initialize arrays\nr = np.zeros((int(t_end / dt), 3))\nv = np.zeros((int(t_end / dt), 3))\n\n# Initial conditions\nr[0] = np.array([r0, 0, 0])\nv[0] = np.array([0, 29.783e3, 0])  # m/s (Earth's velocity at perihelion)\n\n# Verlet integration\nfor i in range(1, int(t_end / dt)):\n    a = -G * M_sun / np.linalg.norm(r[i-1])**3 * r[i-1]\n    r[i] = r[i-1] + v[i-1] * dt + 0.5 * a * dt**2\n    v[i] = v[i-1] + a * dt\n\n# Print the final position and velocity\nprint("Final position:", r[-1])\nprint("Final velocity:", v[-1])