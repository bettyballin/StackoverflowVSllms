$("#someDivId").ajaxComplete(function(request, settings){\n    if (settings.status===404){\n        //redirect here\n    }\n});