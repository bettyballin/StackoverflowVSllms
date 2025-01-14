// Using unary plus to get timestamp\nfunction now() {\n    return +new Date; // Equivalent to new Date().getTime()\n}\n\nconsole.log(now());\n\n// Example of creating an instance without parentheses (discouraged if parameters might be used)\nlet currentDate = new Date;\nconsole.log(currentDate);