var element = document.getElementById('tId');\n   var computedStyle = window.getComputedStyle(element);\n   var currentWidth = computedStyle.getPropertyValue('width');\n   console.log(currentWidth); // Outputs the width as defined in CSS, e.g., "50%"