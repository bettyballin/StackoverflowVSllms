$.getJSON("http://localhost/b/t.php", function(data){\n    $.each(data, function(i, thet){\n        var t = '<li class="name" id="p' + thet.pid + '">' + thet.pid + ' ' + thet.fname + ' ' + thet.lname + '</li>';\n        $(t).appendTo("#" + thet.tour + 'list');\n    });\n    // Move the selector inside the callback function\n    $('li:last-child').css({color: 'red', backgroundColor: 'black'});\n});