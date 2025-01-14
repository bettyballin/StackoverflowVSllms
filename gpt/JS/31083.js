window.onload = function() {\n    XHR.init();\n}\n\nvar XHR = {\n    init: function() {\n        this.createRequest();\n    },\n    createRequest: function() {\n        this.xhr = new XMLHttpRequest();\n        this.xhr.open("GET", "proxy.php?salt=" + Math.round(Math.random() * 10000), true);\n        this.xhr.onreadystatechange = this.process.bind(this);\n        this.xhr.send(null);\n    },\n    process: function() {\n        if (this.xhr.readyState == 4 && this.xhr.status == 200) {\n            // firebug console\n            console.log(this.xhr.responseText);\n            // Start a new request immediately\n            this.createRequest();\n        }\n    }\n}\n\nFunction.prototype.bind = function(obj) {\n    var method = this;\n    return function() {\n        return method.apply(obj, arguments);\n    }\n}