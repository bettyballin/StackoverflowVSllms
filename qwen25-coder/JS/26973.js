function __tabStripPostBack(key) {\n    var tabControlAction = document.getElementById('<%= __TabControlAction.ClientID %>');\n    var tabControlKey = document.getElementById('<%= __TabControlKey.ClientID %>');\n    \n    if (tabControlAction && tabControlKey) {\n        tabControlAction.value = 'Click';\n        tabControlKey.value = key;\n        \n        document.forms["Form1"].submit();\n    } else {\n        console.error("One or more elements not found.");\n    }\n}