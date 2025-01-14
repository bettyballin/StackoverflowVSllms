document.addEventListener("DOMContentLoaded", function() {\n    let observer = new IntersectionObserver(function(entries) {\n        entries.forEach(entry => {\n            if (entry.isIntersecting) {\n                // Load more items\n                loadMoreItems();\n                // To mimic removing old items for demonstration, you can do:\n                removeOldItemsIfNecessary();\n            }\n        });\n    });\n\n    let sentinel = document.getElementById('sentinel');  // This is the element that triggers the loading of more items.\n    observer.observe(sentinel);\n\n    function loadMoreItems() {\n        // Simulate fetching and adding new blog posts\n        console.log("Loading more items...");\n        const container = document.getElementById('blog-container');\n        for (let i = 0; i < 10; i++) {\n            let newPost = document.createElement('div');\n            newPost.className = 'post';\n            newPost.textContent = 'New Blog Post';\n            container.appendChild(newPost);\n        }\n        // Reset or reposition the sentinel after loading\n    }\n\n    function removeOldItemsIfNecessary() {\n        const container = document.getElementById('blog-container');\n        if (container.children.length > 50) {  // Define your logic for when to remove old items\n            let postsToRemove = Array.from(container.children).slice(0, 10);\n            postsToRemove.forEach(post => post.remove());\n        }\n    }\n});