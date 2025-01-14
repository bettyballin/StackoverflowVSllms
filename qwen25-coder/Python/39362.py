def should_rebuild(refactor_effort, rewrite_effort, new_features_possible_with_refactoring, current_code_quality):\n    if refactor_effort > 2 * rewrite_effort:\n        return True\n    if not new_features_possible_with_refactoring and rewrite_effort < (refactor_effort + (0.5 * rewrite_effort)):\n        return True\n    if current_code_quality == 'very_poor':\n        return True\n    return False\n\n# Example usage\nrefactor_effort = 120  # hours estimated for refactoring\nrewrite_effort = 80   # hours estimated for rewriting\nnew_features_possible_with_refactoring = False\ncurrent_code_quality = 'very_poor'\n\ndecision = should_rebuild(refactor_effort, rewrite_effort, new_features_possible_with_refactoring, current_code_quality)\nprint("Should rebuild:", decision)