function setSelectedLeaveCode(leaveCode) {\n    var selectElement = document.getElementById('leaveCode');\n    if (selectElement) {\n        for (var i = 0; i < selectElement.options.length; i++) {\n            if (selectElement.options[i].value === leaveCode.toString()) {\n                selectElement.selectedIndex = i;\n                break;\n            }\n        }\n    } else {\n        console.error('Element with id "leaveCode" not found.');\n    }\n}\n\n// Example usage:\nsetSelectedLeaveCode(14); // This will set the Long Service option as selected.