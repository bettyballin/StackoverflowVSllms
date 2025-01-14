from scipy.stats import binom\n\ndef binomial_cdf(P, N, S):\n    """\n    Calculate the binomial cumulative distribution function.\n\n    Parameters:\n    P (float): Probability of success in a single trial.\n    N (int): Number of trials.\n    S (int): Number of successes.\n\n    Returns:\n    float: Probability of getting S or fewer successes.\n    """\n    # Calculate the CDF for S successes\n    cdf_value = binom.cdf(S, N, P)\n    return cdf_value\n\ndef binomial_cdf_complement(P, N, S):\n    """\n    Calculate the complementary binomial cumulative distribution function.\n\n    Parameters:\n    P (float): Probability of success in a single trial.\n    N (int): Number of trials.\n    S (int): Number of successes.\n\n    Returns:\n    float: Probability of getting S or more successes.\n    """\n    # Calculate the complementary CDF for S successes\n    ccdf_value = 1 - binom.cdf(S - 1, N, P)\n    return ccdf_value\n\n# Example usage\nP = 0.3\nN = 100\nS1 = 20\nS2 = 40\n\n# Probability of getting 20 or fewer successes\nprob_20_or_fewer = binomial_cdf(P, N, S1)\nprint(f"Probability of getting {S1} or fewer successes: {prob_20_or_fewer}")\n\n# Probability of getting 40 or more successes\nprob_40_or_more = binomial_cdf_complement(P, N, S2)\nprint(f"Probability of getting {S2} or more successes: {prob_40_or_more}")