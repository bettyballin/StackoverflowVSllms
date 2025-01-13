function resizeImage(id) {\n    var img = document.getElementById(id);\n    var maxWidth = 800; // Maximum allowed width\n    \n    // Remove any existing width attribute to get the natural width\n    img.removeAttribute("width");\n    \n    // Get the natural width of the image\n    var naturalWidth = img.width;\n    \n    // Adjust the width based on the maximum allowed width\n    if (naturalWidth < maxWidth) {\n        img.width = naturalWidth;\n    } else {\n        img.width = maxWidth;\n    }\n}