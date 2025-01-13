import math\n\ndef logdist(count, threshold=0, maxsize=1.75, minsize=.75):\n    countdist = []\n    mincount = max(threshold, min(count))\n    maxcount = max(count)\n    spread = maxcount - mincount\n    delta = (maxsize - minsize) / float(spread)\n\n    for c in count:\n        logcount = math.log(c / mincount) / math.log(maxcount / mincount)\n        size = delta * logcount * spread + minsize\n        countdist.append({'count': c, 'size': round(size, 3)})\n\n    return countdist