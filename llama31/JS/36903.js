ErrorBox.prototype.setUpErrorBox = function(btnClientID) {\n    if (btnClientID == null) {\n        setTimeout(() => this.setUpErrorBox(), 1000);\n        return;\n    }\n    Event.observe(btnClientID, 'click', () => this.setValSummary());\n}