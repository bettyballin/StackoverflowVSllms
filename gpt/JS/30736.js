$(document).ajaxStart(function () {\n    $('#globalAjaxBusyIndicator').css({ display: "inline" });\n}).ajaxStop(function () {\n    $('#globalAjaxBusyIndicator').hide();\n});