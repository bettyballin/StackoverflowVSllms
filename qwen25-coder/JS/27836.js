function startup() {\n    var canvas = document.getElementById('canvas');\n    var ctx = canvas.getContext('2d');\n    var img = new Image();\n    img.src = 'player.gif';\n    img.onload = function() {\n        // Translate to the bottom center of the image\n        ctx.translate(185, 305); // Adjusted to account for image height and desired position on canvas\n        // Rotate around the bottom center (which is now at 0,0 in transformed context)\n        ctx.rotate(90 * Math.PI / 180);\n        // Draw the image upwards from its bottom center\n        ctx.drawImage(img, -32, -120); // Adjusted to draw the image relative to its bottom center\n    }\n}