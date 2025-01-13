//This is a <div> that wraps around your listboxes\nvar wrapperDiv = document.getElementById('listboxWrapper');\n\n//Get all <select> elements within the <div>\nvar sels = wrapperDiv.getElementsByTagName('SELECT');\n\n//An array to store the width values\nvar widths = new Array();\n\n//Load the array\nfor(var i = 0, l = sels.length; i < l; i++)\n  widths[i] = sels[i].offsetWidth;\n\n//Get the max width\nvar maxW = Math.max(widths);\n\n//Set the max width to all the list boxes\nfor(var sel in sels)\n  sels[sel].style.width = maxW;