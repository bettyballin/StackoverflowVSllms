def assess_risk(priority_factors):\n    score = 0\n    for factor, rating in priority_factors.items():\n        if rating == 'High':\n            score += 3\n        elif rating == 'Medium':\n            score += 2\n        else:\n            score += 1\n    return score\n\n# Example use case: Dictionary with factors and their ratings\nfactors = {\n    "Data Sensitivity": "High",\n    "Regulatory Compliance": "Medium",\n    "Technological Complexity": "Low"\n}\n\nrisk_score = assess_risk(factors)\nprint(f"The calculated risk score is: {risk_score}")