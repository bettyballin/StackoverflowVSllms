$("#project select").change(function(){ // use one selector for all 3 selects\n    $.post("someurl.php",{\n        // data to send\n        completed: $("select#completed").val(),\n        hours:     $("select#hours").val(),\n        who:       $("select#who").val()\n    }, function(data) {\n        // do callback stuff with the server response 'data' here\n    });\n});