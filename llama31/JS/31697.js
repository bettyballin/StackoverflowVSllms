$.ajax({\n    type: "POST",\n    url: "yourwebservice.asmx/GetArchivedFiles",\n    data: "{pageSize: 10, page: 1}",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(data) {\n        if(data.d.error) {\n            window.location.href = "login.aspx";\n        } else {\n            // Handle the successful response\n        }\n    },\n    error: function(xhr, status, error) {\n        // Handle any other errors\n    }\n});