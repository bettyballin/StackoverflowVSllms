$.ajax({\n    type: "GET",\n    url: "/api/Render/RenderControl",\n    data: { controlName: "MyControl", parameters: "someValue" },\n    success: function (data) {\n        $("#myDiv").html(data);\n    }\n});