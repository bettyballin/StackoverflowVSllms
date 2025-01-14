window.onload = function() {\n    XHR.init();\n}\n\nXHR = {\n    xhr: null,\n    init: function() {\n        this.xhr = new XMLHttpRequest();\n        // Include a timestamp to avoid caching issues.\n        this.xhr.open("GET", "proxy.php?salt=" + Math.round(Math.random() * 10000) + "&timestamp=" + new Date().getTime(), true);\n        this.xhr.onreadystatechange = this.process.bind(this);\n        this.xhr.send(null);\n    },\n    process: function() {\n        if (this.xhr.readyState == 4 && this.xhr.status == 200) {\n            console.log(this.xhr.responseText); // Process the server response\n            // Immediately initiate another request after processing.\n            this.init();\n        } else if (this.xhr.readyState == 4) {\n            // Handle non-200 responses or errors.\n            console.error("Request failed with status: " + this.xhr.status);\n            // Optionally, retry or handle error here.\n            setTimeout(function() { this.init(); }.bind(this), 1000); // Retry after a delay on failure\n        }\n    }\n}\n\n// No need to redefine Function.prototype.bind if it's already available in your environment.