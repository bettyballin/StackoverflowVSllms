<script type="text/javascript">\n    $(document).ready(function() {\n        $("#sendSearch").click(function() {\n            $('#loadingDiv').show();\n            $('#sendSearch').attr("disabled", "disabled");\n\n            // these two lines are the workaround\n            this.form.submit();\n            return true;\n        });\n    });\n</script>