(function(open) {\n    XMLHttpRequest.prototype.open = function(method, url) {\n        console.debug('XMLHttpRequest URL:', url);\n        this.addEventListener('load', function() {\n            console.log(this.responseURL.split('?')[0], this.method, this.requestBody || 'No Data');\n        });\n        open.call(this, method, url);\n    };\n})(XMLHttpRequest.prototype.open);