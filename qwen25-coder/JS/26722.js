window.onerror = function(msg, url, lineNo, columnNo, error) {\n       console.error('Script error:', msg + ' at ', url, ':', lineNo, ':', columnNo);\n   };