<script type="text/javascript">\n$(document).ready(function() {  \n    doReady();  \n\n    var prm = Sys.WebForms.PageRequestManager.getInstance();  \n    prm.add_endRequest(function(s, e) {  \n        doReady();  \n    });  \n}); \n\nfunction doReady() {\n    $('.drag').draggable({ revert: true, helper: 'clone' });\n    $('.drop').droppable({\n        tolerance: "touch", // Here should be a string\n        drop: function(event, ui) {\n            $('#myHidden').val('Testy test test');\n            __doPostBack('<%= HiddenButton.UniqueID %>', '');\n            alert($('#myHidden').val()); // Corrected here\n        }\n    });\n} // End of doReady\n</script>