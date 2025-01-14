var canvas = document.getElementById('myCanvas');\nvar ctx = canvas.getContext('2d');\n\n// Turn off image smoothing for pixel perfect rendering\nctx.imageSmoothingEnabled = false;\nctx.mozImageSmoothingEnabled = false;\nctx.webkitImageSmoothingEnabled = false;\n\n// Draw a line from (10.5, 10.5) to (40.5, 40.5)\nctx.beginPath();\nctx.moveTo(10.5, 10.5);\nctx.lineTo(40.5, 40.5);\nctx.strokeStyle = '#00f';\nctx.lineWidth = 1;\nctx.stroke();\n\n// Alternatively, draw from whole numbers to ensure alignment\nctx.beginPath();\nctx.moveTo(11, 11);\nctx.lineTo(41, 41);\nctx.strokeStyle = '#f00';\nctx.lineWidth = 1;\nctx.stroke();