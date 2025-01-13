$.ajax({\n  type: "GET",\n  url: "your-image-url",\n  xhrFields: {\n    responseType: "blob"\n  },\n  success: function(data) {\n    var blob = new Blob([data], { type: "image/jpeg" });\n    var url = window.URL || window.webkitURL;\n    var img = new Image();\n    img.src = url.createObjectURL(blob);\n    // append the image to your page\n    $('body').append(img);\n  }\n});