// Class & Constructor definition\nfunction Rectangle(w,h) {\n    this.width = w;\n    this.height = h;\n}\n\n// Now your class methods go on the prototype object\nRectangle.prototype.area = function() {\n    return this.width * this.height;\n}