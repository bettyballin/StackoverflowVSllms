API = Class.create({\n\n  initialize: function(api_token) {\n    this.api_token = api_token;\n    this.request_uri = new Template('/api/#{api_token}/#{resource}.json');\n    this.status = 0;\n    this.last_result = null;\n  },\n\n  some_api_call: function() {\n    var result = this._request('resource', {'id':1});\n    // and so on...\n  },\n\n  _request: function(resource, params) {\n    var uri = this.request_uri.evaluate({"api_token":this.api_token,"resource":resource});\n    new Ajax.Request(uri, {\n      contentType: 'application/json',\n      method: 'get',\n      parameters: params,\n      onSuccess: function(r) {\n        alert(this);\n        this.last_result = r.responseJSON;\n        this.status = r.status;\n      }.bind(this) // <--- Add this\n    });\n    return this.last_result;\n  }\n\n});