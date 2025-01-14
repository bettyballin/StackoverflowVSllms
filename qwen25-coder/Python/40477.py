class BadInputException(Exception):\n    """Custom exception for bad input."""\n    pass\n\ndef factorial(num):\n    """Computes the factorial of num."""\n    if not isinstance(num, int) or num < 0:\n        raise BadInputException("Input must be a non-negative integer.")\n    result = 1\n    for i in range(2, num + 1):\n        result *= i\n    return result\n\ndef isPalindrome(inputStr):\n    """Tests to see if inputStr is the same backwards and forwards."""\n    if not isinstance(inputStr, str):\n        raise BadInputException("Input must be a string.")\n    return inputStr == inputStr[::-1]\n\ndef sum(nums):\n    """Computes the sum of all the numbers passed in."""\n    if not isinstance(nums, (list, tuple)):\n        raise BadInputException("Input must be a list or tuple.")\n    result = 0\n    for num in nums:\n        if not isinstance(num, (int, float)):\n            raise BadInputException("All elements must be int or float.")\n        result += num\n    return result