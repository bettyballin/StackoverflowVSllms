Element.prototype.fChild = function(){\n    var firstChild = this.firstChild;\n    while(firstChild != null && firstChild.nodeType === 3){\n        firstChild = firstChild.nextSibling;\n    }\n    return firstChild;\n }\n Element.prototype.nSibling = function(){\n    var nextSibling = this.nextSibling;\n    while(nextSibling != null && nextSibling.nodeType === 3){\n        nextSibling = nextSibling.nextSibling;\n    }\n    return nextSibling;\n }