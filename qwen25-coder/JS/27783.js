// Ensure the YUI library and RTE components are loaded\nYAHOO.util.Event.onDOMReady(function() {\n    var myEditor = new YAHOO.widget.SimpleEditor('editorId', {\n        height: '300px',\n        width: '522px'\n    });\n    myEditor.render();\n\n    // Set focus to the editor after it has rendered\n    myEditor.on('afterRender', function() {\n        this.focus();\n    }, myEditor);\n});