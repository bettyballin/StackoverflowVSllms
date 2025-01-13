function isElementVisible(el) {\n    // Check if the element is not hidden by visibility or display\n    const style = getComputedStyle(el);\n    if (style.visibility === 'hidden' || style.display === 'none') {\n        return false;\n    }\n    \n    // Check if the element is within the viewport\n    const rect = el.getBoundingClientRect();\n    if (rect.top >= window.innerHeight || rect.bottom <= 0 ||\n        rect.left >= window.innerWidth || rect.right <= 0) {\n        return false;\n    }\n\n    // Check if the element is not covered by another element\n    const elemAtPoint = document.elementFromPoint(rect.left + rect.width / 2, rect.top + rect.height / 2);\n    return el.contains(elemAtPoint) || elemAtPoint === el;\n}\n\n// Usage example\nconst element = document.getElementById('your-element-id');\nconst visible = isElementVisible(element);\nconsole.log(visible ? 'Element is visible' : 'Element is not visible');