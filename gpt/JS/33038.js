<script type="text/javascript">\n  $(document).ready(function() {\n    doReady();\n\n    var prm = Sys.WebForms.PageRequestManager.getInstance();\n    prm.add_endRequest(function(s, e) {\n        doReady();\n    });\n  });\n\n  function doReady() {\n    $('.drag').draggable({ revert: true, helper: 'clone' });\n    $('.drop').droppable({\n      tolerance: "touch",\n      drop: function() {\n        alert('dropped');\n        // Update hidden label and trigger postback\n        document.getElementById('<%= HiddenLabel.ClientID %>').innerText = "your_value";\n        __doPostBack('<%= HiddenButton.ClientID %>', '');\n      }\n    });\n  }\n</script>