$.ajax({\n    type: "POST",\n    url: "YourPage.aspx/GetServerTime",\n    data: "{}",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(response) {\n        alert("Server time is: " + response.d);\n    },\n    error: function(error) {\n        console.log("Error: ", error);\n    }\n});