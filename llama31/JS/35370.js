function gcd(a, b) {\n  if (b === 0) {\n    return a;\n  }\n  return gcd(b, a % b);\n}\n\nfunction calculateAspectRatio(width, height) {\n  const gcdValue = gcd(width, height);\n  return `${width / gcdValue}:${height / gcdValue}`;\n}