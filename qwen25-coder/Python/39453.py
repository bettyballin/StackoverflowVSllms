function determineBlockSize(inputData):\n    blockSize = INITIAL_BLOCK_SIZE  # e.g., 16k or 32k\n    currentBlockEntropy = calculateEntropy(inputData.slice(0, blockSize))\n    \n    for i from blockSize to length(inputData) with step BLOCK_STEP_SIZE:\n        if hasHighEntropyChange(inputData[i - blockSize:i]) or \n           compressionImprovementThresholdMet(inputData[0:i]):\n            yield inputData[0:i]\n            inputData = inputData[i:]\n            i = 0\n            currentBlockEntropy = calculateEntropy(inputData.slice(0, blockSize))\n    \n    yield inputData\n\nfunction calculateEntropy(data):\n    # Entropy calculation logic here\n    return entropyValue\n\nfunction hasHighEntropyChange(previousBlock, currentBlock):\n    # Compare entropies of previous and current blocks\n    return abs(calculateEntropy(previousBlock) - calculateEntropy(currentBlock)) > THRESHOLD\n\nfunction compressionImprovementThresholdMet(data):\n    # Determine if new block could improve compression significantly\n    return compressionRatioImprove(newEncodeWithFreshTrees(data), newEncodeWithoutFreshTrees(data)) > IMPROVEMENT_THRESHOLD