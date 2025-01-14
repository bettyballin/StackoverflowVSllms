$.ajax({\n  url: o.url,\n  type: 'POST',\n  contentType: "application/json; charset=utf-8",\n  data: JSON.stringify({"method":"getStates", "program":"EXPLORE"}),\n  success: function (data, status) {\n    console.log("Success!!"); // Log successful response\n    console.log(data);        // Handle the data returned from server\n    console.log(status);\n  },\n  error: function (xhr, desc, err) {\n    console.log(xhr.responseText);\n    console.log('Desc: ' + desc + '\nErr:' + err);\n  }\n});