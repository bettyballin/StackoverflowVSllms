$.ajax({\n    // your ajax settings here\n    beforeSend: function () {\n        $('#ajaxBusyIndicator_<%=partido.PartidoId.ToString()%>').css({ display: "inline" });\n    },\n    complete: function () {\n        $('#ajaxBusyIndicator_<%=partido.PartidoId.ToString()%>').hide();\n    }\n});