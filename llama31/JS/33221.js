var gridFilter = Ext.DomHelper.append(gridToolbar, {\n    tag: "input",\n    type: "text",\n    size: "25",\n    value: "",\n    cls: "x-grid-filter"\n});\ngridFilter.on("focus", function(){this.dom.select();});