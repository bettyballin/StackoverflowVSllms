// Push new state\n   history.pushState({ domState: currentState }, 'page title', '/new-url');\n\n   // Listen for popstate event\n   window.addEventListener('popstate', (event) => {\n       if (event.state && event.state.domState) {\n           // Restore the DOM state\n       }\n   });