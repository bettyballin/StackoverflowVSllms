var divTag = content.document.createElement("img");                 \ndivTag.id = "div1";\n// Assuming image1.gif is in an images directory inside your extension\ndivTag.src = browser.runtime.getURL("images/image1.gif");\ndivTag.setAttribute("align","center");\ndivTag.style.margin = "0px auto";\ndivTag.style.position = "fixed";\ndivTag.style.bottom = "0px";\ndivTag.style.height = "22px";\ndivTag.style.width = "100%";\ncontent.document.getElementsByTagName('body')[0].appendChild(divTag);