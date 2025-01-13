$(function() {\n  var $tab = $('<div id="feedback-tab">Feedback</div>');\n  $('body').append($tab);\n\n  $tab.css({\n    'position': 'fixed',\n    'top': '50%',\n    'right': '-20px',\n    'background-color': '#fff',\n    'border': '1px solid #ccc',\n    'padding': '10px',\n    'cursor': 'pointer'\n  });\n\n  $tab.on('click', function() {\n    // Redirect to your desired URL\n    window.location.href = 'https://your-feedback-page.com';\n  });\n\n  // Optional: animate the tab on hover\n  $tab.hover(function() {\n    $(this).animate({ right: '0px' }, 200);\n  }, function() {\n    $(this).animate({ right: '-20px' }, 200);\n  });\n});