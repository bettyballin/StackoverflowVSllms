// Parent page\nvar frame = document.getElementById('rsPrintFrame');\nframe.contentWindow.postMessage('findComponent', 'componentId');\n\n// Framed page\nwindow.addEventListener('message', function(event) {\n  if (event.data === 'findComponent') {\n    var component = Sys.Application.findComponent(event.data);\n    // Send the component instance back to the parent page\n    parent.postMessage(component, '*');\n  }\n}, false);