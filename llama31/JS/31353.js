// Add an event listener to all ad links\ndocument.querySelectorAll('a.ad-link').forEach((link) => {\n  link.addEventListener('click', (event) => {\n    // Prevent the default link behavior\n    event.preventDefault();\n\n    // Send user's information to your server\n    fetch('/track-click', {\n      method: 'POST',\n      headers: {\n        'Content-Type': 'application/json',\n      },\n      body: JSON.stringify({\n        // Collect user's information here\n        userId: '123',\n        adId: 'abc',\n      }),\n    })\n      .then((response) => response.json())\n      .then((data) => {\n        // Redirect the user to the original ad link\n        window.location.href = link.href;\n      })\n      .catch((error) => {\n        console.error('Error tracking click:', error);\n      });\n  });\n});