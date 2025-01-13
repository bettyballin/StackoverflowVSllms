function spawnNewWindow(url, title, type) {\n       var cancelSpawn = false;\n       if ($('.windowType_' + type).length) {\n           $('.windowType_' + type).children("iframe").attr("src", "/darknova4/" + url);\n       } else {\n           // Create the window\n           $("body").append(\n               "<div class='window'> \\n<div class='resizeArea'></div> \\n<div class='titlebar'>" + title + "</div> \\n<div class='closeWindow'></div> \\n<div class='windowContent newspawn'><iframe src='/darknova4/" + url + "' frameborder='0' width='100%' height='100%' scrolling='auto'></iframe></div> \\n</div>");\n\n           // Move this window to the top of the stack\n           $(".newspawn").parent(".window").css("z-index", windowZIndex++);\n\n           // Set the data for this window's type\n           $(".newspawn").addClass("windowType_" + type);\n\n           // Setup the window for moving and resizing\n           setupWindows();\n\n           // Force a repaint\n           var iframe = $(".newspawn iframe")[0];\n           iframe.style.display = 'none';\n           iframe.offsetHeight; // Trigger a reflow\n           iframe.style.display = '';\n\n           // Remove the "newspawn" flag\n           $(".newspawn").removeClass("newspawn");\n       }\n   }