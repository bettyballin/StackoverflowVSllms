$("input#title").get(0).setAttribute("maxlength", 25); // Corrected attribute name\n$("input#title").get(0).setAttribute(\n    "onkeypress", \n    "return limitMe(event, this)"\n);\n\nfunction limitMe(evt, txt) {\n    if (evt.which && evt.which == 8) return true; // Allow backspace\n    else return (txt.value.length < parseInt(txt.getAttribute("maxlength"))); // Use correct attribute name and parse it as integer\n}