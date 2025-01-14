<script type="text/javascript">\n    var prm = Sys.WebForms.PageRequestManager.getInstance();\n    prm.add_initializeRequest(initializeRequest);\n    prm.add_endRequest(endRequest);\n\n    function initializeRequest(sender, args) {\n        // Pause the update\n        args.set_cancel(true);\n\n        // Fade out the content\n        fadeOutAndPauseUpdatePanel();\n    }\n\n    function fadeOutAndPauseUpdatePanel() {\n        var updatePanel = document.getElementById('<%= UpdatePanel1.ClientID %>');\n        var opacity = 1;\n        var timer = setInterval(function() {\n            if (opacity <= 0.1) {\n                clearInterval(timer);\n                updatePanel.style.display = 'none';\n\n                // Resume the update after fade out\n                prm._doPostBack();\n            }\n            updatePanel.style.opacity = opacity;\n            updatePanel.style.filter = 'alpha(opacity=' + opacity * 100 + ")";\n            opacity -= opacity * 0.1;\n        }, 50);\n    }\n\n    function endRequest(sender, args) {\n        // Fade in the content\n        fadeInUpdatePanel();\n    }\n\n    function fadeInUpdatePanel() {\n        var updatePanel = document.getElementById('<%= UpdatePanel1.ClientID %>');\n        var opacity = 0.1;\n        updatePanel.style.display = 'block';\n        var timer = setInterval(function() {\n            if (opacity >= 1) {\n                clearInterval(timer);\n            }\n            updatePanel.style.opacity = opacity;\n            updatePanel.style.filter = 'alpha(opacity=' + opacity * 100 + ")";\n            opacity += opacity * 0.1;\n        }, 50);\n    }\n</script>