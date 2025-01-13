// Get the object/embed tag\nvar swfObject = document.getElementById('example_flashGame');\n\n// Get the actual width and height of the SWF file\nvar swfWidth = swfObject.contentDocument.width;\nvar swfHeight = swfObject.contentDocument.height;\n\n// Set the maximum allowed width and height\nvar maxWidth = 600;\nvar maxHeight = 400;\n\n// If the SWF file size exceeds the maximum allowed size, set the size to the maximum allowed size\nif (swfWidth > maxWidth || swfHeight > maxHeight) {\n  swfObject.width = maxWidth;\n  swfObject.height = maxHeight;\n} else {\n  // Otherwise, set the size to the actual size of the SWF file\n  swfObject.width = swfWidth;\n  swfObject.height = swfHeight;\n}