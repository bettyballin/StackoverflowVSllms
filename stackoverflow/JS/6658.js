function mouseMove(e)\n{\n    var mouseX, mouseY;\n\n    if(e.offsetX) {\n        mouseX = e.offsetX;\n        mouseY = e.offsetY;\n    }\n    else if(e.layerX) {\n        mouseX = e.layerX;\n        mouseY = e.layerY;\n    }\n\n    /* do something with mouseX/mouseY */\n}