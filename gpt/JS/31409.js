var canvas = document.getElementById('myCanvas');\nvar ctx = canvas.getContext('2d');\nvar space = 10; // Example space between lines, adjust as needed\nvar canvasWidth = 320;\nvar canvasHeight = 320;\nvar x = 0;\n\nfor (var i = 0; i < 5; i++) {\n    x += space;\n\n    // Draw red vertical line\n    ctx.beginPath();\n    ctx.moveTo(x, 0);\n    ctx.lineTo(x, canvasHeight);\n    ctx.strokeStyle = "rgb(200,0,0)";\n    ctx.stroke();\n\n    // Draw green horizontal line\n    ctx.beginPath();\n    ctx.moveTo(0, x);\n    ctx.lineTo(canvasWidth, x);\n    ctx.strokeStyle = "rgb(0,200,0)";\n    ctx.stroke();\n}