document.querySelectorAll('link, script, img').forEach(el => {\n    if (el.src && !el.src.startsWith('https://')) {\n        console.log(`Non-secure resource found: ${el.src}`);\n    }\n});