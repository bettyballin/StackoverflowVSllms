// Get the iframe element\nvar iframe = document.getElementById('yourIframeId');\n\n// Ensure the iframe is loaded\niframe.onload = function() {\n  // Access the iframe's document\n  var iframeDocument = iframe.contentDocument || iframe.contentWindow.document;\n\n  // Get the div element within the iframe\n  var divElement = iframeDocument.querySelector('div');\n\n  // Do something with the div element\n  console.log(divElement);\n};