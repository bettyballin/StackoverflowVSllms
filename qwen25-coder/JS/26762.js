// Cross-browser event listener attachment\n   function addEventListener(element, eventName, eventHandler) {\n       if (element.addEventListener) {\n           element.addEventListener(eventName, eventHandler, false);\n       } else if (element.attachEvent) { // For IE < 9\n           element.attachEvent('on' + eventName, eventHandler);\n       }\n   }