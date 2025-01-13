bool is_palindrome_recursive(const char* str, int length, int left, int right) {\n    if (left >= right) return true;\n    if (str[left] != str[right]) return false;\n    return is_palindrome_recursive(str, length, left + 1, right - 1);\n}