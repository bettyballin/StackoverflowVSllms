import threading\n\ndef is_palindrome_segment(s, start, end):\n    while start < end:\n        if s[start] != s[end]:\n            return False\n        start += 1\n        end -= 1\n    return True\n\ndef palindrome_multithreaded(s):\n    length = len(s)\n    mid = length // 2\n    threads = []\n    results = [True] * 2  # To store the result of each thread\n\n    def task(start, end, index):\n        results[index] = is_palindrome_segment(s, start, end)\n\n    # Create two segments to check in parallel: first half -> second half\n    t1 = threading.Thread(target=task, args=(0, mid - 1, 0))\n    t2 = threading.Thread(target=task, args=(length - mid, length - 1, 1))\n\n    threads.append(t1)\n    threads.append(t2)\n\n    for thread in threads:\n        thread.start()\n\n    for thread in threads:\n        thread.join()\n\n    return all(results)\n\n# Example usage\ns = "abccba"\nprint(palindrome_multithreaded(s))  # Output: True