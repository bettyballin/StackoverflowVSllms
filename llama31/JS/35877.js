$("#<%=btnContinue.ClientID%>").click(function(e) {\n    // ...\n    $.ajax({\n        // ...\n    });\n    e.preventDefault(); // Add this line\n});