// Get the data URL from localStorage\nvar dataURL = localStorage.getItem('image');\n\n// Create a new image element\nvar img = new Image();\nimg.src = dataURL;