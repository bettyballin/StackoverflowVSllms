document.addEventListener('DOMContentLoaded', function() {\n    var element = document.getElementById('your-element-id'); // Replace 'your-element-id' with your element's ID\n\n    var hoverTimer;\n\n    element.addEventListener('mouseover', function() {\n        hoverTimer = setTimeout(function() {\n            // Show your popup here\n            console.log('Popup should appear now!');\n            // Example: element.nextElementSibling.style.display = 'block';\n        }, 500); // Adjust the delay time here (in milliseconds)\n    });\n\n    element.addEventListener('mouseout', function() {\n        clearTimeout(hoverTimer);\n        // Optionally, hide your popup if it's already shown\n        // Example: element.nextElementSibling.style.display = 'none';\n    });\n});