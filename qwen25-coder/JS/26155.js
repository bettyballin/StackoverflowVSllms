const validator = require('validator');\n\nfunction isValidUrl(string) {\n  return validator.isURL(string, { protocols: ['http', 'https'], require_protocol: true });\n}\n\n// Example usage:\nconsole.log(isValidUrl("http://stackoverflow.com")); // true\nconsole.log(isValidUrl("javascript:alert('hacked!');")); // false