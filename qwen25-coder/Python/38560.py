import numpy as np\n\n# Sample data: old_points and new_points are Nx2 arrays\nold_points = np.array([[x1, y1], [x2, y2], ..., [xn, yn]])\nnew_points = np.array([[x1_prime, y1_prime], [x2_prime, y2_prime], ..., [xn_prime, yn_prime]])\n\n# Preparing the matrices for normal equations\nN = old_points.shape[0]\nA = np.zeros((2*N, 4))\nb = np.zeros(2*N)\n\nfor i in range(N):\n    x, y = old_points[i]\n    xp, yp = new_points[i]\n    A[2*i] = [x, y, 1, 0]  # Coefficients for R + Px + Qy\n    A[2*i+1] = [-y, x, 0, 1]  # Coefficients for S - Qx + Py\n    b[2*i] = xp\n    b[2*i+1] = yp\n\n# Solving the normal equations: A^T * A * [P, Q, R, S]^T = A^T * b\nAT_A = np.dot(A.T, A)\nAT_b = np.dot(A.T, b)\n\n# Manually solving for [P, Q, R, S]\n# You should use a method to solve Ax=b that is numerically stable in practice, e.g., using LU decomposition or QR factorization\nparams = np.linalg.solve(AT_A, AT_b)\n\n# Extracting parameters\nR, P, Q, S = params\n\n# Covariance matrix estimation\nsigma2 = (np.sum(np.square(np.dot(A, params) - b))) / (2*N - 4)\ncov_matrix = sigma2 * np.linalg.inv(AT_A)\n\n# Standard deviations of the estimated parameters\nstd_devs = np.sqrt(np.diag(cov_matrix))\n\nprint(f"Estimated Parameters:\n R={R}, P={P}, Q={Q}, S={S}")\nprint("Standard Deviations:", std_devs)