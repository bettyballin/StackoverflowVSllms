$(document).ready(function() {\n    $("#btnAddNewUserj").click(function() { ShowNewUserDialog(); return false; });\n\n    $("#btnSearch").click(function() { FindUsers(); return false; });\n\n    $("#newuserDialog").dialog({\n        modal: true,\n        bgiframe: true,\n        autoOpen: false,\n        close: function() {\n            // Optionally reset the dialog contents on close\n            $('#usersTable tbody').empty();\n            $('#txtSearchFor').val('');\n        }\n    });\n\n    $("#btnjAdd").click(function() {\n        var selectedUsers = [];\n        $('#usersTable input[type="checkbox"]:checked').each(function() {\n            selectedUsers.push($(this).parent().next().text());\n        });\n        \n        // TODO: Process the selection (e.g., send to server for DB insertion)\n        alert("Adding users: " + selectedUsers.join(", "));\n    });\n\n    $("#btnjCancel").click(function() { \n        $("#newuserDialog").dialog("close"); \n    });\n});\n\nfunction ShowNewUserDialog() {\n    $("#newuserDialog").dialog("open");\n}\n\nfunction FindUsers() {\n    var searchCriteria = $('#txtSearchFor').val();\n    \n    $.ajax({\n        type: 'GET',\n        url: '/UserController/GetUsers', // Update with your server-side action URL\n        data: { query: searchCriteria },\n        dataType: 'json',\n        success: function(data) {\n            PopulateTable(data);\n        },\n        error: function(xhr, status, err) {\n            console.error("Failed to fetch users", xhr.responseText);\n        }\n    });\n}\n\nfunction PopulateTable(users) {\n    var tbody = $('#usersTable tbody').empty();\n    $.each(users, function(index, user) {\n        $('<tr>')\n            .append($('<td>').append($('<input>', { type: 'checkbox' })))\n            .append($('<td>').text(user.Name))\n            .append($('<td>').text(user.Email))\n            .appendTo(tbody);\n    });\n}