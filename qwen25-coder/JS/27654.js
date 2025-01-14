// Select the last item where we want to trigger loading more content\nconst target = document.querySelector('.last-item');\n\n// Callback function that will be executed when the target element is visible\nconst callback = (entries, observer) => {\n  entries.forEach(entry => {\n    if (entry.isIntersecting) { // If the target element is visible\n      loadMoreContent(); // Call the function to load more content\n      observer.unobserve(target); // Optionally unobserve after loading more items\n    }\n  });\n};\n\n// Create an Intersection Observer instance and pass the callback function\nconst options = {\n  root: null, // This makes the viewport our root element\n  threshold: 1.0 // We want to know when the whole target is visible\n};\nconst observer = new IntersectionObserver(callback, options);\n\n// Start observing the target node for visibility changes\nobserver.observe(target);\n\n// Function that handles loading more content\nfunction loadMoreContent() {\n  // Simulate loading more items (e.g., via AJAX)\n  console.log('Loading more content...');\n  // Here you would typically make an AJAX call or some async operation to fetch and append new data\n}