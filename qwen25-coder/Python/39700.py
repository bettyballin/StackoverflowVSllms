from packaging import version\n\ndef compare_versions(v1, v2):\n    return version.parse(v1) < version.parse(v2)\n\n# Example usage:\nv1 = "1.4"\nv2 = "1.38"\n\nprint(compare_versions(v1, v2))  # Output: True, indicating 1.4 is less than 1.38