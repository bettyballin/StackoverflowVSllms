function getWebServiceUrl() {\n    return '<%= ResolveUrl("~/MyWebService.asmx/MyWebMethod") %>';\n}\n\n$.ajax({\n    type: "POST",\n    url: getWebServiceUrl(),\n    data: "{}",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(msg)\n    // ...\n});