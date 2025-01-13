$(document).ready(function() {
\n  switches = $('#switches > li');
\n  slides = $('#slides > div');
\n  switches.each(function(idx) {
\n    $(this).data('slide', slides.eq(idx));
\n  }).hover(
\n    function() {
\n      switches.removeClass('active');
\n      slides.removeClass('active');
\n      $(this).addClass('active');
\n      $(this).data('slide').addClass('active');
\n    });
\n});