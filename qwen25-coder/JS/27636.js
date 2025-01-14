function getElementXPath(element) {\n    if (element.id !== '') {\n        return 'id("' + element.id + '")';\n    }\n    if (element === document.body) {\n        return element.tagName;\n    }\n\n    let ix = 0;\n    let siblings = element.parentNode.childNodes;\n    for (let i = 0; i < siblings.length; i++) {\n        let sibling = siblings[i];\n        if (sibling === element) {\n            return getElementXPath(element.parentNode) + '/' + element.tagName.toLowerCase() + '[' + (ix+1) + ']';\n        }\n        if (sibling.nodeType === 1 && sibling.tagName.toLowerCase() === element.tagName.toLowerCase()) {\n            ix++;\n        }\n    }\n}\n\n// Example usage:\nlet faqLink = document.querySelector('a[href="/help"]');\nconsole.log(getElementXPath(faqLink));