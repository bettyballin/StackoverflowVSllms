// Create the input field and add it to the toolbar\nvar filterInput = gridToolbar.addField(Ext.create('Ext.form.TextField', {\n    width: 200,\n    listeners: {\n        focus: function() { this.select(); } // Automatically select text on focus\n    }\n}));\n\n// If you need a reference to the Ext.Element, use its .el property\nvar gridFilter = filterInput.el;