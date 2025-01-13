function roundedCorners(image, cornerRadius) {\n    const canvas = document.createElement('canvas');\n    const ctx = canvas.getContext('2d');\n    canvas.width = image.width;\n    canvas.height = image.height;\n\n    ctx.beginPath();\n    ctx.moveTo(0, cornerRadius);\n    ctx.quadraticCurveTo(0, 0, cornerRadius, 0);\n    ctx.lineTo(image.width - cornerRadius, 0);\n    ctx.quadraticCurveTo(image.width, 0, image.width, cornerRadius);\n    ctx.lineTo(image.width, image.height - cornerRadius);\n    ctx.quadraticCurveTo(image.width, image.height, image.width - cornerRadius, image.height);\n    ctx.lineTo(cornerRadius, image.height);\n    ctx.quadraticCurveTo(0, image.height, 0, image.height - cornerRadius);\n    ctx.closePath();\n\n    ctx.clip();\n    ctx.drawImage(image, 0, 0);\n    return canvas.toDataURL();\n}\n\n// Usage:\nconst image = document.getElementById('image');\nconst cornerRadius = 20;\nconst result = roundedCorners(image, cornerRadius);\ndocument.getElementById('result').src = result;