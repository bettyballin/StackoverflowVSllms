const { URL } = require('url');\n\nfunction isValidUrl(string) {\n  try {\n    new URL(string);\n    return true;\n  } catch (_) {\n    return false;\n  }\n}\n\n// Example usage:\nconsole.log(isValidUrl("http://stackoverflow.com")); // true\nconsole.log(isValidUrl("javascript:alert('hacked!');")); // false