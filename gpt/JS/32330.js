var values = {\n        "id": "200",\n        "FirstName": "Chris",\n        "DynamicItem1": "Some Value",\n        "DynamicItem2": "Some Other Value"\n    };\n\n    $.ajax({\n        url: "/Controller/AddItems",\n        type: "POST",\n        contentType: "application/json; charset=utf-8",\n        dataType: "json",\n        data: JSON.stringify(values),\n        success: function(response) {\n            // handle the response\n        },\n        error: function(xhr, status, error) {\n            // handle the error\n        }\n    });