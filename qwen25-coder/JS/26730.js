fetch: function(site, callback) {\n    var req = new Request({\n        method: this.options.method,\n        url: this.options.rssFetchPath,\n        data: { 'url': site },\n        onRequest: function() {\n            if (this.options.targetId) {\n                $(this.options.targetId).setProperty('html', this.options.onRequestMessage);\n            }\n        }.bind(this),\n        onSuccess: function(responseText) {\n            callback(responseText); // Pass the response to the callback\n        }\n    });\n    req.send();\n}