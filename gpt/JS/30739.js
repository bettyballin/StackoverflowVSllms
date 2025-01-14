function extractFirstUserRight(csvString) {\n  const match = csvString.match(/(?:^|;)(LA_[^;]*)/);\n\n  if (match && match[1]) {\n    return match[1];\n  } else {\n    return '';\n  }\n}\n\n// Example usage:\nconst csvString = "LA_1;LA_2;LE_3;";\nconsole.log(extractFirstUserRight(csvString)); // Output: LA_1