$.ajax({\n    type: "GET",\n    url: "Modules/" + ModuleID + "/ModuleContent.xml",\n    dataType: "xml",\n    mimeType: "text/xml",\n    success: function(x) { xml = x; ProcessXML(); },\n    error: function(x) { alert(x.responseText); }\n});