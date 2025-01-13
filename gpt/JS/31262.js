function gcd(a, b) {\n  return b == 0 ? a : gcd(b, a % b);\n}\n\nfunction getAspectRatio(width, height) {\n  const divisor = gcd(width, height);\n  const aspectWidth = width / divisor;\n  const aspectHeight = height / divisor;\n  return `${aspectWidth}:${aspectHeight}`;\n}\n\n// Example usage:\nconst width = 1920;\nconst height = 1080;\nconst aspectRatio = getAspectRatio(width, height);\nconsole.log(aspectRatio); // Outputs: "16:9"