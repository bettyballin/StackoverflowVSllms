// Get the parent element of the divs\nconst parent = document.getElementById('parent');\n\n// Get the divs\nconst div1 = document.getElementById('div1');\nconst div2 = document.getElementById('div2');\nconst div3 = document.getElementById('div3');\n\n// Reorder the divs\nparent.insertBefore(div2, div1);\nparent.insertBefore(div1, div3);