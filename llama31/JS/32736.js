var iframe = document.createElement('iframe');\niframe.src = 'back-button-detector.html';\ndocument.body.appendChild(iframe);\n\niframe.onload = function() {\n  // The user has clicked on the back button\n  // You can update your application state here\n};