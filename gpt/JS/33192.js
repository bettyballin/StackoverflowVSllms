function isIE6() {\n    var userAgent = window.navigator.userAgent;\n    var isIE6 = userAgent.indexOf("MSIE 6.0") > -1;\n    return isIE6;\n}\n\nif (isIE6()) {\n    alert("You are using Internet Explorer 6");\n} else {\n    alert("You are not using Internet Explorer 6");\n}