var items = [\n    { compId: "1", formId: "531" },\n    { compId: "2", formId: "77" },\n    { compId: "3", formId: "99" },\n    { status: "2", statusId: "8" },\n    { name: "Value", value: "myValue" }\n];\n\nvar options = {\n    error: function(jqXHR, textStatus, errorThrown) {\n        alert('Error: ' + jqXHR.responseText);\n    },\n    type: "POST",\n    url: "PackageList.aspx/SaveRecord",\n    data: JSON.stringify({ items: items }), // key should be a string\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    async: false,\n    success: function(response) {\n        var results = response.d;\n        console.log(results); // or handle the result as needed\n    }\n};\njQuery.ajax(options);