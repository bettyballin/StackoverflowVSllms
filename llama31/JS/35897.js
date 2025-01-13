// Send a message to the parent page with the new dimensions\nfunction sendDimensions() {\n  var body = document.body;\n  var width = body.offsetWidth;\n  var height = body.offsetHeight;\n  parent.postMessage({ width: width, height: height }, '*');\n}\n\n// Send dimensions on load and on resize\nwindow.addEventListener('load', sendDimensions);\nwindow.addEventListener('resize', sendDimensions);