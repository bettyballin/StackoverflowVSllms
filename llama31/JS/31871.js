function getImageSize(url) {\n  var xhr = new XMLHttpRequest();\n  xhr.open('HEAD', url, true);\n  xhr.onreadystatechange = function() {\n    if (xhr.readyState === 4) {\n      var fileSize = xhr.getResponseHeader('Content-Length');\n      if (fileSize !== null) {\n        console.log('File size:', fileSize);\n      } else {\n        console.log('Failed to retrieve file size');\n      }\n    }\n  };\n  xhr.send();\n}