Object.prototype.doAjaxCall = function(url) {\n    $.get(url, null, () => this.handleAjaxResponse());\n};