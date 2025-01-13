text: 'Remove',\ntooltip: 'Remove attribute',\niconCls: 'silk-table_delete',\nhandler: function() {\n    var selectedItem = attributeEditor.getSelectionModel().getSelected();\n\n    // Check if we have selected item\n    if (selectedItem) {\n        // Get selected item value\n        var attribute = selectedItem.get('Name');\n\n        // Remove selected item from store\n        attributeStore.remove(selectedItem);\n\n        // Clear any modifications on the removed record\n        selectedItem.reject();\n\n        // Add to our removed attributes hash if it has an id\n        if (selectedItem.id) {\n            RemovedAttributes.push(attribute);\n        }\n    } else {\n        wispUserFormWindow.getEl().mask();\n\n        // Display error\n        Ext.Msg.show({\n            title: "Nothing selected",\n            msg: "No attribute selected",\n            icon: Ext.MessageBox.ERROR,\n            buttons: Ext.Msg.CANCEL,\n            modal: false,\n            fn: function() {\n                wispUserFormWindow.getEl().unmask();\n            }\n        });\n    }\n}