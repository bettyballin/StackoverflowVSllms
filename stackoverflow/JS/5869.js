var searchTimeout;\ndocument.getElementById('searchBox').onkeypress = function () {\n    if (searchTimeout != undefined) clearTimeout(searchTimeout);\n    searchTimeout = setTimeout(callServerScript, 250);\n};\nfunction callServerScript() {\n    // your code here\n}