// Direct method using .prev() repeated\nvar N = 2; // e.g., second from last\nvar element = $('ul li.last');\nfor (var i = 0; i < N - 1; i++) {\n    element = element.prev();\n}\nelement.css('color', 'red'); // Example action: change color