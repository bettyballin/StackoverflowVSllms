var form = document.createElement("form");\n\nform.setAttribute("method", "post");\nform.setAttribute("action", "test.jsp");\nform.setAttribute("target", "_blank"); // This will open the result in a new window\n\nvar hiddenField = document.createElement("input");  \nhiddenField.setAttribute("name", "id");\nhiddenField.setAttribute("value", "bob");\nform.appendChild(hiddenField);\ndocument.body.appendChild(form); \nform.submit();