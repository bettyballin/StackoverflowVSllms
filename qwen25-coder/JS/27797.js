<script>\n    $(document).ready(function() {\n        $("#formSearch").submit(function() { \n            var options = {    \n                url: "http://localhost:8081/sniper/estabelecimento/pesquisar.action",\n                success: function(responseText) {\n                    // Clear existing content in #divResult\n                    $('#divResult').empty().html(responseText);\n                }\n            }      \n            $(this).ajaxSubmit(options);      \n            return false;\n        });\n    })\n</script>