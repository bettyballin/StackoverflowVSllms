/**************************************************************************\n *\n * Function:    toggleVis\n *\n * Description: Following Function hides and expands the main column.\n *              Also saves and restores visibility state from/to a cookie.\n ***************************************************************************/\n// Set the default "show" mode to that specified by W3C DOM compliant browsers\n\nvar showMode = 'table-cell';\n\n// However, IE5 at least does not render table cells correctly using the style 'table-cell', but does when the style 'block' is used, so handle this\nif (document.all) {\n    showMode='block';\n}\n\nfunction getCookie(name) {\n    var nameEQ = name + "=";\n    var ca = document.cookie.split(';');\n    for(var i=0;i < ca.length;i++) {\n        var c = ca[i];\n        while (c.charAt(0)==' ') c = c.substring(1,c.length);\n        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);\n    }\n    return null;\n}\n\nfunction setCookie(name,value,exdays) {\n    var d = new Date();\n    d.setTime(d.getTime() + (exdays*24*60*60*1000));\n    var expires = "expires=" + d.toUTCString();\n    document.cookie = name + "=" + value + ";" + expires + ";path=/";\n}\n\nvar States = {};\n\n// Load initial states from cookies\nfunction loadStates() {\n    for (let col in getCookie("colStates").split('&')) {\n        let [key, value] = col.split('=');\n        States[key] = {isOpen: JSON.parse(value)};\n    }\n}\n\nif (getCookie("colStates")) {\n    loadStates();\n} else {\n    // Set default states\n    document.getElementsByName('yourColumnName').forEach(cell => {\n        var col = cell.className; // Adjust this line based on how your columns are identified\n        States[col] = {isOpen: true}; // Change to false if you want hidden by default\n    });\n}\n\nfunction toggleVis(col){\n    if (!States[col] || States[col].IsOpen == null) {\n        States[col] = {isOpen : JSON.parse(getCookie(col)) || true}; \n    }\n\n    mode =  States[col].IsOpen ? 'none' : showMode; \n\n    cells = document.getElementsByName(col);\n    for(j = 0; j < cells.length; j++) cells[j].style.display = mode;\n\n    States[col].IsOpen = !States[col].IsOpen;\n    saveStateToCookie();\n}\n\nfunction saveStateToCookie() {\n    let colStates = Object.keys(States).map(key => `${key}=${JSON.stringify(States[key].isOpen)}`).join('&');\n    setCookie("colStates", colStates, 7); // Expires after one week\n}