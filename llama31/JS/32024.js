$.ajax({\n  url: "Inquire.ashx",\n  data: data,\n  dataType: "text",\n  timeout: 5000,\n  cache: false, // add this property\n  complete: function(xhr, status) {\n    var resp = xhr.responseText;\n\n    if(resp.substr(0, 4) == "http")\n      window.open(resp, "PopWin");\n    else\n      showError(resp);\n  }\n});