function resizeBox() {\n    const box = document.getElementById('resizableBox');\n    // Toggle between two sizes for demonstration\n    if (box.style.width === '200px' || box.style.width === '') {\n        box.style.width = '300px';\n        box.style.height = '250px';\n    } else {\n        box.style.width = '200px';\n        box.style.height = '150px';\n    }\n}