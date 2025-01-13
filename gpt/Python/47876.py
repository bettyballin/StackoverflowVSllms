import numpy as np\n\n   def gravitational_force(m1, m2, r1, r2):\n       G = 6.67430e-11  # gravitational constant\n       r = np.linalg.norm(r2 - r1)\n       force = G * m1 * m2 / r**2 * (r2 - r1) / r\n       return force