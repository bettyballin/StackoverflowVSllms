$(document).ready(function() {\n    $('#pv_list li:first').addClass('hilite');\n    $("input[name='db_entries']:first").attr('checked', 'checked');\n    $("input[name='db_entries']").click(function () {\n        $.post("changeEntry.php", { post: $(this).val() }, function(data) {\n            $("textarea").val(data); // Use .val() instead of .text() to update textarea content\n            alert('done');\n        });\n        $('#pv_list li').removeClass('hilite');\n        $(this).parent().addClass('hilite');\n    });\n});