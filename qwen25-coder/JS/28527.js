function ConnectionManager() {\n  var eventObject = $('<span id="ConnectionManager"></span>').appendTo("body");\n  var activeConnections = 0;\n  var maxConnections = 5;\n\n  this.getEventObject = function() {\n    return eventObject;\n  };\n\n  this.isConnectionAvailable = function() {\n    return activeConnections < maxConnections;\n  };\n\n  this.AcquireConnection = function() {\n    if (activeConnections < maxConnections) {\n      activeConnections++;\n      return true;\n    } else {\n      return false;\n    }\n  };\n\n  this.ReleaseConnection = function() {\n    activeConnections--;\n    eventObject.trigger('connReleased');\n  };\n}\n\nfunction initThumbnails() {\n  var queue = new ImageQueue(document.querySelectorAll('.thumbnail-link')); // Assume .thumbnail-link is your link class\n\n  function loadNextInQueue() {\n    if (queue.isEmpty()) return;\n\n    while (queue.isNotEmpty() && connectionManager.AcquireConnection()) {\n      let imageLink = queue.dequeue();\n      const loader = new Image();\n\n      loader.onload = function () {\n        imageLink.firstChild.src = imageLink.href;\n        connectionManager.ReleaseConnection();\n        loadNextInQueue(); // Load next image in queue\n      };\n\n      loader.onerror = function () {\n        console.error('Image failed to load:', imageLink.href);\n        connectionManager.ReleaseConnection();\n        loadNextInQueue(); // Attempt to load next even if one fails\n      };\n\n      loader.src = imageLink.dataset.thumbnail || imageLink.href; // Use thumbnail URL if available\n    }\n  }\n\n  const connectionManager = new ConnectionManager();\n\n  // Trigger initial loading process\n  loadNextInQueue();\n\n  // Lazy Loading Integration (simplified, adjust based on your framework or vanilla JS preference)\n  let observer = new IntersectionObserver((entries) => {\n    entries.forEach(entry => {\n      if (entry.isIntersecting) {\n        queue.enqueue(entry.target.parentElement); // Assuming each entry is the thumbnail img tag\n        loadNextInQueue(); // Try to start loading images as soon as they become visible\n      }\n    });\n  });\n\n  document.querySelectorAll('.thumbnail-img').forEach(img => observer.observe(img));\n}\n\n// Helper Class for managing image queues\nclass ImageQueue extends Set {\n  isEmpty() {\n    return this.size === 0;\n  }\n\n  isNotEmpty() {\n    return !this.isEmpty();\n  }\n\n  dequeue() {\n    const iterator = this.values();\n    const firstValue = iterator.next().value;\n    this.delete(firstValue);\n    return firstValue;\n  }\n}\n\n// Call this function on document ready\ndocument.addEventListener('DOMContentLoaded', initThumbnails);