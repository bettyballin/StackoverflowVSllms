<div id="myElement">Hover over me!</div>\n<div id="dialog" style="display:none;">This is the dialog box content.</div>\n\n<script>\n    $(document).ready(function () {\n        $("#myElement").mouseover(function () {\n            $.ajax({\n                type: "GET",\n                url: '@Url.Action("GetDialogContent", "MyController")',\n                success: function (data) {\n                    $("#dialog").html(data).dialog("open");\n                }\n            });\n        });\n\n        $("#dialog").dialog({\n            autoOpen: false,\n            width: 400,\n            height: 200,\n            modal: true\n        });\n    });\n</script>