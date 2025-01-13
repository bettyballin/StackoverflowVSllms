import numpy as np\n\ndef sinusoidal_signal(n, freq, amp, noise):\n    x = amp * np.sin(2 * np.pi * freq * np.arange(n)) + noise * np.random.normal(0, 1, n)\n    return x