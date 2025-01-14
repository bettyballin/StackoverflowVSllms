// Select the image document\nvar doc = app.activeDocument;\n\n// Create a new rectangular slice\ndoc.sliceSelectTool();\n\n// Define slice dimensions (example values)\nvar x = 0;\nvar y = 0;\nvar width = 200;\nvar height = 200;\n\n// Draw the slice\ndoc.selection.select([[x, y], [x + width, y], [x + width, y + height], [x, y + height]], SelectionType.REPLACE);\n\n// Create a slice object\nvar newSlice = doc.artLayers.add();\nnewSlice.name = "exampleSlice";\n\n// Exporting slices programmatically is a bit more complex and usually done through GUI options or advanced scripting