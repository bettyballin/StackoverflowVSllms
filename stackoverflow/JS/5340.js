function replaceIt(txtarea, newtxt) {
\n  $(txtarea).val(
\n        $(txtarea).val().substring(0, txtarea.selectionStart)+
\n        newtxt+
\n        $(txtarea).val().substring(txtarea.selectionEnd)
\n   );  
\n}
\n    
\n
\n$("button").on('click', function() {
\n  replaceIt($('textarea')[0], 'fun')
\n})