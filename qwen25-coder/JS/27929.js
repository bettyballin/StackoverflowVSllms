<script language="JavaScript">\nfunction Inint_AJAX() {\n    try { return new ActiveXObject("Msxml2.XMLHTTP"); } catch(e) {}\n    try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch(e) {}\n    try { return new XMLHttpRequest(); } catch(e) {}\n    alert("XMLHttpRequest not supported");\n    return null;\n}\n\nfunction dochange(src, val) {\n    var req = Inint_AJAX();\n    if (req == null) return;\n\n    req.onreadystatechange = function () {\n        if (req.readyState === 4 && req.status === 200) {\n            document.getElementById(src).innerHTML = req.responseText;\n        }\n    };\n    req.open("GET", "traditional_locate.php?data=" + encodeURIComponent(src) + "&val=" + encodeURIComponent(val), true);\n    req.send(null);\n}\n\nwindow.onload = function() {\n    dochange('cities', -1); // Ensure this is called after the window has fully loaded\n};\n\nfunction submitform() {\n    if (validate()) { // Call directly validate() instead of document.form1.onsubmit()\n        document.form1.submit();\n    }\n}\n</script>