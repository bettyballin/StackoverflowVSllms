if (navigator.userAgent.indexOf('MSIE 6') !== -1) {\n        // Apply specific changes for IE6\n        document.querySelectorAll('.your-date-picker-class').forEach(function(element) {\n            element.style.width = '150px'; // Adjust width\n            element.style.fontSize = '12px'; // Adjust font size\n        });\n    }