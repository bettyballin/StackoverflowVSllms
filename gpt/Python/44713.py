def is_palindrome_recursive(s):\n    def helper(left, right):\n        if left >= right:\n            return True\n        if s[left] != s[right]:\n            return False\n        return helper(left + 1, right - 1)\n\n    return helper(0, len(s) - 1)