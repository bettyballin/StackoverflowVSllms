function addItem(itemValue) {\n    var listBox = document.getElementById("yourListBoxId");\n    var option = document.createElement("option");\n    option.text = itemValue;\n    listBox.add(option);\n}