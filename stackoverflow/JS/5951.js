// Download the image data using AJAX, I'm using jQuery\nvar imageData = $.ajax({ url: "MyImage.gif", async: false }).responseText;\n\n// Image data updating magic\nimageDataChanged = ChangeImage(imageData);\n\n// Encode to base64, maybe try the webtoolkit.base64.js library\nimageDataEncoded = Base64Encode(imageDataChanged);\n\n// Write image data out to browser (FF seems to support this)\ndocument.write('<img src="data:image/gif;base64,' + imageDataEncoded + '">');