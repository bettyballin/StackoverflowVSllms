var _xhr = XMLHttpRequest.prototype.open;\nXMLHttpRequest.prototype.open = function(methodType, url) {\n    this.addEventListener('load', function() {\n        console.log('Request URL:', url);\n        console.log('Method Type:', methodType);\n        console.log('Status:', this.status);\n        console.log('Response:', this.responseText);\n    });\n    _xhr.apply(this, arguments);\n};