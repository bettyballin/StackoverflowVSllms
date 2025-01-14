// Function to open a new window and attempt to make it fullscreen\nfunction openFullScreenPopup(url) {\n    // Open the new window with specific dimensions\n    var popup = window.open(url, 'popup', \n                              'width=' + screen.availWidth +\n                              ',height=' + screen.availHeight);\n\n    // Request full-screen for the newly opened window\n    if (popup && popup.document.documentElement.requestFullscreen) {\n        popup.addEventListener('load', function() {\n            try {\n                popup.document.documentElement.requestFullscreen();\n            } catch(e) {\n                console.error("Error attempting to enable full-screen mode: " + e.message);\n            }\n        });\n    }\n\n    // Fallback for different browser prefixes\n    else if (popup && popup.document.documentElement.mozRequestFullScreen) { // Firefox\n        popup.addEventListener('load', function() {\n            try {\n                popup.document.documentElement.mozRequestFullScreen();\n            } catch(e) {\n                console.error("Error attempting to enable full-screen mode: " + e.message);\n            }\n        });\n    }\n    else if (popup && popup.document.documentElement.webkitRequestFullscreen) { // Chrome, Safari and Opera\n        popup.addEventListener('load', function() {\n            try {\n                popup.document.documentElement.webkitRequestFullscreen();\n            } catch(e) {\n                console.error("Error attempting to enable full-screen mode: " + e.message);\n            }\n        });\n    }\n    else if (popup && popup.document.documentElement.msRequestFullscreen) { // IE11+\n        popup.addEventListener('load', function() {\n            try {\n                popup.document.documentElement.msRequestFullscreen();\n            } catch(e) {\n                console.error("Error attempting to enable full-screen mode: " + e.message);\n            }\n        });\n    }\n}\n\n// Example usage\nopenFullScreenPopup('https://example.com');