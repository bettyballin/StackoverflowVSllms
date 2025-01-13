from math import log\n\ndef logdist(count, threshold=0, maxsize=1.75, minsize=0.75):\n    countdist = []\n    mincount = max(threshold, min(count))\n    maxcount = max(count)\n    spread = maxcount - mincount\n    \n    if spread == 0:\n        delta = maxsize - minsize\n        for c in count:\n            countdist.append({'count': c, 'size': round(minsize + delta / 2, 3)})\n    else:\n        delta = (maxsize - minsize) / log(maxcount - mincount + 1)\n        for c in count:\n            logcount = log(c - mincount + 1)\n            size = minsize + delta * logcount\n            countdist.append({'count': c, 'size': round(size, 3)})\n    \n    return countdist\n\n# Example usage\ncount = [1, 3, 5, 4, 7, 5, 10, 6]\nresult = logdist(count)\nfor item in result:\n    print(item)