function loadContentAndResize() {\n    const xhr = new XMLHttpRequest();\n    xhr.open('GET', 'your-url-here', true);\n    xhr.onreadystatechange = function () {\n        if (xhr.readyState === 4 && xhr.status === 200) {\n            document.getElementById('content').innerHTML = xhr.responseText;\n            imagesLoaded();\n        }\n    };\n    xhr.send();\n}\n\nfunction imagesLoaded() {\n    const container = document.getElementById('content');\n    const images = container.getElementsByTagName('img');\n    let loadedImagesCount = 0;\n\n    if (images.length === 0) {\n        resizeContainer(); // No images, resize immediately\n        return;\n    }\n\n    function loadImage(image) {\n        image.onload = function () {\n            loadedImagesCount++;\n            if (loadedImagesCount === images.length) {\n                resizeContainer();\n            }\n        };\n        image.onerror = function () {\n            loadedImagesCount++; // Count as loaded even if there's an error\n            if (loadedImagesCount === images.length) {\n                resizeContainer();\n            }\n        };\n\n        // Start loading the image if not already loaded\n        if (!image.complete) {\n            const src = image.src; // Trigger load event by accessing src again\n            image.src = '';\n            image.src = src;\n        } else {\n            loadedImagesCount++;\n        }\n    }\n\n    for (let i = 0; i < images.length; i++) {\n        loadImage(images[i]);\n    }\n}\n\nfunction resizeContainer() {\n    // Your code to resize the container here\n    console.log('All images loaded, resizing container...');\n}