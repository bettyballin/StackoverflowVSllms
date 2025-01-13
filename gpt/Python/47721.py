import os\n\ndef createDirectory(myKey, **myDict):\n    pathList = []\n    pathList.append(myDict['subKey1'])\n    pathList.append(myDict['subKey2'].lstrip('0'))\n    pathList.append(myDict['subKey3'])\n\n    # Ensure pathList is correctly populated\n    etc = 'etc'  # Replace with actual logic as needed\n    pathList.append(etc)\n    \n    myPath = os.path.join(*pathList)\n    \n    # Ensure the directory does not already exist to avoid exceptions\n    if not os.path.exists(myPath):\n        os.makedirs(myPath)\n    \n    return myPath