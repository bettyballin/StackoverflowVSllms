function disableElement(element) {\n  var overlay = $('<div class="overlay"></div>');\n  overlay.css({\n    position: 'absolute',\n    top: 0,\n    left: 0,\n    width: '100%',\n    height: '100%',\n    zIndex: 1000,\n    backgroundColor: 'transparent'\n  });\n  $(element).append(overlay);\n}\n\nfunction enableElement(element) {\n  $(element).find('.overlay').remove();\n}\n\n// usage\ndisableElement('#mydiv');