function my_ajax(aurl, adata, aretfunc) {\n  $.ajax({\n    type: "POST",\n    url: aurl,\n    data: adata,\n    success: function(msg) {\n      msg = $.trim(msg); // Trim the response\n      eval(aretfunc + '(msg);');\n    }\n  });\n}