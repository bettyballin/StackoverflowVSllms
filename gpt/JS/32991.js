window.addEventListener("load", function () {\n    const scrollPosition = localStorage.getItem("scrollPosition");\n    if (scrollPosition) {\n        window.scrollTo(0, parseInt(scrollPosition, 10));\n        localStorage.removeItem("scrollPosition"); // Optional: remove after restoring to avoid interfering with other pages\n    }\n});