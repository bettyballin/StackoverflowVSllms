<script type="text/javascript">\n       function addControls() {\n           var div = document.getElementById("dynamicDiv");\n           var input1 = document.createElement("input");\n           input1.type = "text";\n           input1.id = "HtmlInputText1";\n           input1.name = "HtmlInputText1";\n           \n           var input2 = document.createElement("input");\n           input2.type = "text";\n           input2.id = "HtmlInputText2";\n           input2.name = "HtmlInputText2";\n           \n           var hiddenField = document.createElement("input");\n           hiddenField.type = "hidden";\n           hiddenField.id = "HiddenField1";\n           hiddenField.name = "HiddenField1";\n           hiddenField.value = "100"; // Example height value\n           \n           div.appendChild(input1);\n           div.appendChild(input2);\n           div.appendChild(hiddenField);\n       }\n   </script>