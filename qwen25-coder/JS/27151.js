function getSelectedParagraph() {\n    var selection = window.getSelection();\n    if (selection.rangeCount > 0) {\n        var range = selection.getRangeAt(0);\n        var startNode = range.startContainer;\n        \n        // Ensure we are working with an Element, not a TextNode\n        var element = startNode instanceof HTMLElement ? startNode : startNode.parentNode;\n\n        while (element && element.tagName.toLowerCase() !== 'p') {\n            element = element.parentElement;\n        }\n\n        if (element) {\n            return element.textContent || element.innerText; // Return the paragraph text\n        }\n    }\n    return null; // If no paragraph is found, return null\n}\n\nconsole.log(getSelectedParagraph());