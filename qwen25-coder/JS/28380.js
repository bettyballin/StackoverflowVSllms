function loadImage(imageSrc){\n    var timestamp = new Date().getTime();\n    var html = "<img src=\"" + imageSrc + "?t=" + timestamp + "\" />";\n    document.getElementById('content').innerHTML=html;\n}