$.ajax({\n    type: "DELETE",\n    url: "/SomeEndpoint",\n    data: {\n        "Param2": param0val,\n        "Param1": param1val\n    },\n    success: function(data, textStatus, jqXHR) {\n        var contentType = jqXHR.getResponseHeader("content-type") || "";\n        if (contentType.indexOf("application/json") !== -1) {\n            // Handle JSON response\n            var jsonResponse = JSON.parse(data);\n            console.log("JSON response:", jsonResponse);\n        } else if (contentType.indexOf("text/html") !== -1) {\n            // Handle HTML response\n            console.log("HTML response:", data);\n        } else if (contentType.indexOf("application/xml") !== -1 || contentType.indexOf("text/xml") !== -1) {\n            // Handle XML response\n            console.log("XML response:", data);\n        } else {\n            // Handle other response types\n            console.log("Other response type:", data);\n        }\n    },\n    error: function(res, textStatus, errorThrown) {\n        alert('failed... :(');\n    }\n});