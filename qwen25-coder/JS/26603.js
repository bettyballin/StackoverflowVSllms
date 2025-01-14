function isValidString(input) {\n    // Regular expression to match any of the unwanted characters: / \ & ;\n    var regex = /[\\/&;]/;\n    return !regex.test(input);\n}\n\n// Example usage:\nconsole.log(isValidString("This is a test")); // true\nconsole.log(isValidString("This is a test/")); // false\nconsole.log(isValidString("This is a test\\")); // false\nconsole.log(isValidString("This is a test&")); // false\nconsole.log(isValidString("This is a test;")); // false