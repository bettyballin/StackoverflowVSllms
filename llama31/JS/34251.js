function ShowPanel(control) {\n    var accordion = $find('<%= MyAccordion.ClientID %>');\n    var ctrl = accordion.get_Panes()[0].get_Contents().getElementsByTagName('input')[1];\n    ctrl.disabled = true;\n}