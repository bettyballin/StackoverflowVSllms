// Define your store\n   var store = Ext.create('Ext.data.Store', {\n     fields: ['id', 'name', 'associated_model_id', 'associated_model_name'],\n     proxy: {\n       type: 'ajax',\n       url: '/models',\n       reader: {\n         type: 'json',\n         root: 'data'\n       }\n     },\n     autoLoad: true\n   });\n\n   // Define your grid\n   Ext.create('Ext.grid.Panel', {\n     title: 'My Grid',\n     store: store,\n     columns: [\n       { text: 'ID', dataIndex: 'id' },\n       { text: 'Name', dataIndex: 'name' },\n       { text: 'Associated Model', dataIndex: 'associated_model_name' } // Reference the virtual attribute here\n     ],\n     renderTo: Ext.getBody()\n   });