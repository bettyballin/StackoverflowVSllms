function MakeCall(url, callback) {\n  $.ajax({\n    url: url,\n    dataType: "text",\n    complete: function(xhr, status) {\n      if (xhr.responseText == "false") {\n        args.IsValid = false;\n      }\n    }\n  });\n}