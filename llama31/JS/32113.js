// Get the image\nvar img = new Image();\nimg.src = 'image.jpg';\n\n// Create a new cache\ncaches.open('image-cache').then(function(cache) {\n  // Add the image to the cache\n  cache.put(img.src, new Response(img));\n});