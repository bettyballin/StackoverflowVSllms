function isIE() {\n    var ua = window.navigator.userAgent;\n    return (ua.indexOf("MSIE ") > -1 || ua.indexOf("Trident/") > -1);\n}\n\nif (!isIE()) {\n    alert('This link will only work in Internet Explorer. Please open this page in IE to proceed.');\n} else {\n    document.some_form.submit();\n}