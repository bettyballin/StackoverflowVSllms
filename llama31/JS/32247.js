$.ajax({\n    type: "POST",\n    url: "TestDBLoader.aspx/LoadDBAsync",\n    data: "{}",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function (msg) {\n        document.getElementById('txtResult').value = msg.d;\n    }\n});