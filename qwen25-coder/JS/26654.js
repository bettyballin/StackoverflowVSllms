function scrollToLine(textarea, lineNumber) {\n    // Get the computed style object for the textarea\n    const style = window.getComputedStyle(textarea);\n    \n    // Extract the line-height property value and convert it to a number\n    let lineHeight = parseFloat(style.lineHeight);\n\n    // If lineHeight is not correctly parsed (e.g., in some cases where 'normal' is set), fall back\n    if (isNaN(lineHeight)) {\n        // Approximate line height based on font size, assuming 1.2em line-height for normal\n        const fontSize = parseFloat(style.fontSize);\n        lineHeight = fontSize * 1.2;\n    }\n\n    // Calculate the scrollTop value for the desired line number\n    const scrollTopValue = (lineNumber - 1) * lineHeight;\n\n    // Set the scrollTop property of the textarea\n    textarea.scrollTop = scrollTopValue;\n}\n\n// Example usage:\nconst myTextarea = document.getElementById('myTextarea');\nscrollToLine(myTextarea, 345);