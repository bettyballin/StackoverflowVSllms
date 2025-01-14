$.get('template.html', function(template) {\n       function renderUser(data) {\n           var $clone = $(template);\n           $clone.find('.thumb').attr('src', data.avatarUrl || 'default-avatar.jpg');\n           $clone.find('.username').text(data.username);\n           $clone.find('.name').text(data.name);\n           return $clone;\n       }\n\n       // Usage\n       var userData = {avatarUrl: 'path/to/avatar.jpg', username: 'johndoe', name: 'John Doe'};\n       $('#userList').append(renderUser(userData));\n   });