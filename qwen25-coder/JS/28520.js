// Function to create and save a child window's content\nfunction saveFriendlyPage(htmlContent) {\n    // Create a new window\n    var child = window.open("", "_blank", "width=600,height=400");\n    \n    if (child) {  // Check if the window was successfully opened\n        // Write necessary document structure to the child window\n        child.document.write('<!DOCTYPE html>');\n        child.document.write('<html><head><title>Save Friendly Page</title></head><body>');\n        child.document.write(htmlContent);  // Write the HTML content\n        child.document.write('</body></html>');\n        \n        // Give some time for the document to fully load before prompting save\n        setTimeout(function() {\n            child.focus();  // Focus on the child window to ensure it's active\n        }, 200);\n    } else {\n        alert('Popup blocked! Please allow popups from this site.');\n    }\n}\n\n// Example usage:\nvar htmlPage = '<h1>My Save Friendly Page</h1><p>This is a save-friendly version of the original page.</p>';\nsaveFriendlyPage(htmlPage);