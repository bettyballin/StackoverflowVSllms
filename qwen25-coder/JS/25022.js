$.getJSON("http://localhost/b/t.php", function(data){\n    var $ol = $("#" + data[0].tour + 'list'); // Assuming tour is the same for all entries\n\n    $.each(data, function(i, thet){\n        var t = '<li class="name" id="p' + thet.pid + '">' + thet.pid + ' ' + thet.fname + ' ' + thet.lname + '</li>';\n        $(t).appendTo($ol);\n    });\n\n    // Style the last child after all items are appended\n    $ol.find('li:last-child').css({color: 'red', backgroundColor: 'black'});\n});