function MakeCall(url, callback) {\n  $.ajax({\n    url: url,\n    dataType: "text",\n    success: callback\n  });\n}