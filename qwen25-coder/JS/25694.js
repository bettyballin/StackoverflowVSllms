var links_in_row = document.evaluate(\n  ".//a[starts-with(text(),'Keyword')]",\n  row,\n  null,\n  XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,\n  null);\n\nfor (var i = 0; i < links_in_row.snapshotLength; i++) {\n    var link = links_in_row.snapshotItem(i);\n    console.log(link.href); // Output the href of each link\n}