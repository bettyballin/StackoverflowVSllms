(function(global) {\n       var myWidget = {};\n\n       myWidget.jsonpCallback = function(data) {\n           // Handle JSONP response\n       };\n       \n       var script = document.createElement('script');\n       script.src = 'https://example.com/api?callback=myWidget.jsonpCallback';\n       document.body.appendChild(script);\n       \n       global.myWidget = myWidget;\n   })(window);