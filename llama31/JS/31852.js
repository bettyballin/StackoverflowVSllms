// assume 'signature' is the div element containing the signature\nvar images = signature.getElementsByTagName('img');\nfor (var i = 0; i < images.length; i++) {\n  var url = images[i].src;\n  getImageSize(url);\n}