tempDetails.prototype.showData = function() {\n       if (this.req.readyState == 4) {\n           var container = this.loadedLayer;\n           container.style.overflow = 'visible';\n\n           container.innerHTML = "";\n           container.innerHTML = this.req.responseText;\n\n           // Trigger reflow/repaint\n           var dummy = container.offsetWidth; // Reading a layout property triggers reflow\n       }\n   };