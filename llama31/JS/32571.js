$.ajaxSetup({\n  complete: function(xhr, status) {\n    if (xhr.status == 302) {\n      var redirectUrl = xhr.getResponseHeader('Location');\n      window.location.href = redirectUrl;\n    }\n  }\n});