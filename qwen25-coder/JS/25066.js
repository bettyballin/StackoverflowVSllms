<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>\n<script type="text/javascript">\n    $(document).ready(function () {\n        // Attach click event via jQuery after page load and postbacks\n        Sys.WebForms.PageRequestManager.getInstance().add_endRequest(function () {\n            $('[id$=yourCheckboxClientID]').off('click').on('click', function () {\n                checkClick();\n            });\n        });\n\n        // Initial binding on first page load\n        $('[id$=yourCheckboxClientID]').click(checkClick);\n    });\n\n    function checkClick() {\n        // Your event handling code here\n        console.log('Checkbox clicked!');\n    }\n</script>