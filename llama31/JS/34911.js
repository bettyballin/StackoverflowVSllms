function off() {\n  var f1 = document.getElementById("f1");\n  var f2 = document.getElementById("f2");\n  alert("before, frame f1 had border=" + f1.getAttribute("border"));\n  f1.setAttribute("border", "0");\n  alert("after, frame f1 has border=" + f1.getAttribute("border"));\n  alert("before, frame f2 had border=" + f2.getAttribute("border"));\n  f2.setAttribute("border", "0");\n  alert("after, frame f2 has border=" + f2.getAttribute("border"));\n}