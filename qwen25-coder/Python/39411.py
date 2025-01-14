function convertDecimalFractionToBase(decimal, base, precision):\n    integerPart = int(decimal)\n    fractionPart = decimal - integerPart\n    convertedInteger = ''\n    while integerPart > 0:\n        remainder = integerPart % base\n        convertedInteger = str(remainder) + convertedInteger\n        integerPart = integerPart // base\n    \n    convertedFraction = ''\n    count = 0\n    while fractionPart != 0 and count < precision:\n        fractionPart *= base\n        digit = int(fractionPart)\n        if digit >= 10:  # For bases greater than 10, convert to A-F\n            convertedFraction += chr(digit - 10 + ord('A'))\n        else:\n            convertedFraction += str(digit)\n        fractionPart -= digit\n        count += 1\n    \n    return convertedInteger + '.' + convertedFractio