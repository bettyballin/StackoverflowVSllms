// Get all elements with class "tumme"\nvar elements = document.getElementsByClassName("tumme");\n\n// Update the innerHTML of each element\nfor (var i = 0; i < elements.length; i++) {\n  elements[i].innerHTML = xmlHttp.responseText;\n}