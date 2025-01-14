function getTextOffset(range) {\n    var root = range.parentElement();\n    var testRange = root.createTextRange();\n    var origEnd = range.duplicate();\n\n    // Select all contents in the parent element\n    testRange.moveToElementText(root);\n\n    // Iterate through each character to find the offset\n    for (var i = 0; testRange.compareEndPoints("EndToEnd", range) < 0; ++i) {\n        testRange.moveEnd('character', 1);\n    }\n\n    return i;\n}\n\n// Usage\nvar range = document.selection.createRange();\nvar offset = getTextOffset(range);\nconsole.log("Character offset: " + offset);