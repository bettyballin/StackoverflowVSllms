<script type="text/javascript">\n    function update(pk, enable) {\n        $.ajax({\n            url: "ajaxcall.asp",\n            type: "POST",\n            success: function (output) {\n                var status = output;\n                if (status == 1) {\n                    // Toggle the image source\n                    var src = ($('#' + 'img' + pk).attr("src") == "img/cross.gif") ? "img/tick.gif" : "img/cross.gif";\n                    $('#' + 'img' + pk).attr("src", src);\n                    \n                    // Toggle the onclick attribute of the parent anchor tag\n                    var newEnable = (enable === 'yes') ? 'no' : 'yes';\n                    $('#' + 'img' + pk).parent().attr('onclick', "update('" + pk + "', '" + newEnable + "')");\n                }\n            },\n            data: 'pk=' + pk + '&enable=' + enable\n        });\n    }\n</script>