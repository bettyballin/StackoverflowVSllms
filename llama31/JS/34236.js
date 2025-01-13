// script.js (Tab Management)\n\nfunction openTab(tabName) {\n    var i, tabcontent, tablinks;\n    tabcontent = document.getElementsByTagName("iframe");\n    for (i = 0; i < tabcontent.length; i++) {\n        tabcontent[i].style.display = "none";\n    }\n    tablinks = document.getElementsByClassName("tab-button");\n    for (i = 0; i < tablinks.length; i++) {\n        tablinks[i].className = tablinks[i].className.replace(" active", "");\n    }\n    document.getElementById(tabName).style.display = "block";\n    document.querySelector('[onclick="openTab(\'' + tabName + '\')"]').className += " active";\n}