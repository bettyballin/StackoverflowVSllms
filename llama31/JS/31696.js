function onPanelStateChanged(sender, args) {\n    var panelId = sender.get_id();\n    var isExpanded = sender.get_expanded();\n    var hiddenField = document.getElementById('<%= panelStates.ClientID %>');\n    var currentState = hiddenField.value;\n    var newState = currentState + ';' + panelId + '=' + isExpanded;\n    hiddenField.value = newState;\n}