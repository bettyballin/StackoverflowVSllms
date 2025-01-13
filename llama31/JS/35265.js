var gridLayout = [\n  new dojox.grid.cells.RowIndex({ name: "row #", \n                                  width: 2, \n                                  styles: "text-align: right;"\n                               }),\n  {\n    field: "ele_id",\n    name: "Element ID",\n    styles: "text-align:right;",\n    width:5,\n    hidden:false // make sure this is false or remove the property\n  },\n  {\n    field: "ele_nm",\n    name: "Element Name",\n    styles: "text-align:left;",\n    width:8\n  }\n];