<script type="text/javascript">\n\nif (gup("ok") != 1) {\n    if (gup("source") != window.location.href) {\n        window.location = window.location.href + "?&source=" + window.location.href + "&ok=1";\n    }\n}\n\nfunction gup( name ){  \n\n    //This function returns the URL parameter specified\n    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");  \n    var regexS = "[\\?&]"+name+"=([^&#]*)";  \n    var regex = new RegExp( regexS );  \n    var results = regex.exec( window.location.href );  \n    if( results == null )    \n        return "";  \n    else    \n        return results[1];\n\n}\n\n</script>