$.ajax({\n    url: "/ajax/test",\n    type: "POST",\n    contentType: "application/json", // Set content type to application/json\n    dataType: "json", // Expect JSON in response\n    data: JSON.stringify({ // Convert your data to a JSON string\n        keyword: $('#tbxBrand').val(),\n        projectguid: "<%= thisProject.ProjectGuid.ToString() %>",\n        userguid: "<%= thisUser.UserGuid.ToString() %>"\n    }),\n    beforeSend: function() { },\n    success: function(data) {\n        alert(data); // Adjust based on data type received\n    }\n});