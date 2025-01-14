// jQuery Event Delegation\n$(document).ready(function() {\n    $('body').on('click', '.show-comments', function(event) {\n        event.preventDefault(); // Prevent the default action of the link\n\n        var newsId = $(this).data('news-id'); // Get the news ID from data attribute\n        showhideComments(newsId); // Call your existing function with the news ID\n    });\n});