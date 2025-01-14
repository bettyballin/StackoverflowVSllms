function addValueClick()\n{\n    var newValue = prompt("Please enter a new value.", "");\n    if (newValue != null && newValue != "")\n    {\n        var lst = document.getElementById("lstValues");\n        var opt = document.createElement("option");\n        opt.setAttribute("selected", "true");\n        opt.appendChild(document.createTextNode(newValue));\n        lst.appendChild(opt);\n        \n        // Fix: Set the width style of the select element to maintain its size\n        lst.style.width = lst.offsetWidth + 'px';\n        \n        updateBtns();\n        copyValues();\n    }\n}