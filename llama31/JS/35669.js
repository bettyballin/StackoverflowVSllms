var MyCode = {\n    req: new XMLHttpRequest(), // firefox only at the moment\n\n    service_url: "http://url/to/Service.asmx",\n\n    sayhello: function() {\n        if (this.req.readyState == 4 || this.req.readyState == 0) {\n            this.req.open("POST", this.service_url + '/HelloWorld', true);\n            this.req.setRequestHeader('Content-Type','application/json; charset=utf-8');\n            this.req.onreadystatechange = this.handleReceive.bind(this); // bind the context of 'this'\n            var param = '{}';\n            this.req.send(param);\n        }\n    },\n\n    handleReceive: function() {\n        if (this.req.readyState == 4) {\n            // todo: using eval for json is dangerous\n            var response = eval("(" + this.req.responseText + ")");\n            alert(response);\n        }\n    }\n}