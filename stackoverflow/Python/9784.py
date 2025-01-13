import math\n\ndef BestTick(largest, mostticks):\n    minimum = largest / mostticks\n    magnitude = 10 ** math.floor(math.log(minimum) / math.log(10))\n    residual = minimum / magnitude\n    if residual > 5:\n        tick = 10 * magnitude\n    elif residual > 2:\n        tick = 5 * magnitude\n    elif residual > 1:\n        tick = 2 * magnitude\n    else:\n        tick = magnitude\n    return tick