// In your JavaScript file\ndocument.addEventListener('DOMContentLoaded', function() {\n  const slides = document.querySelectorAll('#slideshow .slide');\n  let currentSlide = 0;\n\n  setInterval(function() {\n    slides[currentSlide].style.display = 'none';\n    currentSlide = (currentSlide + 1) % slides.length;\n    slides[currentSlide].style.display = 'block';\n  }, 3000); // Change the slide every 3 seconds\n});