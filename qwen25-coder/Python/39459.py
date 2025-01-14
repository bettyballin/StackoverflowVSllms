function findSmallestWindow(A, B):\n    // Maps to store frequency of each element in B and current counts in sliding window\n    requiredCount = map with key as element, value as count from B\n    currentCount = empty map\n    for each element in B:\n        increment count of element in requiredCount\n\n    start = 0\n    end = 0\n    bestStart = -1\n    bestEnd = -1\n    found = 0 // Counter for elements fully satisfied in the window\n    minLength = infinity\n\n    while end < length of A:\n        // Expand the window by including A[end]\n        element = A[end]\n        if element is in requiredCount:\n            increment count of element in currentCount\n            if currentCount[element] == requiredCount[element]:\n                increment found\n\n        // Check if we've satisfied all elements of B\n        while found == length of requiredCount and start <= end:\n            // Update the minimum window size\n            if end - start + 1 < minLength:\n                minLength = end - start + 1\n                bestStart = start\n                bestEnd = end\n\n            // Try to shrink the window from the left\n            element = A[start]\n            if element is in requiredCount:\n                decrement count of element in currentCount\n                if currentCount[element] < requiredCount[element]:\n                    decrement found\n            increment start\n\n        increment end\n\n    if bestStart != -1 and bestEnd != -1:\n        return (bestStart, bestEnd)\n    else:\n        return (-1, -1)