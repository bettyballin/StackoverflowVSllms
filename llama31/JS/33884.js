var timer;\n\nfunction showPopup() {\n    // Code to show the popup\n}\n\nfunction onMouseOver() {\n    clearTimeout(timer);\n    timer = setTimeout(showPopup, 500); // 500ms delay\n}\n\nfunction onMouseOut() {\n    clearTimeout(timer);\n}