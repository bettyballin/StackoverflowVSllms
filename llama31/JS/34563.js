$.ajax({\n    type: "POST",\n    url: "/MyController/MyAction",\n    data: { id: 1 },\n    success: function(data) {\n        console.log(data);\n    }\n});