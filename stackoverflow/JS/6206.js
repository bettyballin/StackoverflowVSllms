var marq = document.getElementsByTagName('marquee')[0];\n var div = document.createElement('div');\n div.innerHTML = marq.innerHTML;\n marq.parentNode.appendChild(div);\n marq.parentNode.removeChild(marq);