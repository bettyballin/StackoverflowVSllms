function facebookLogout() {\n  FB.logout(function(response) {\n    // User is now logged out\n    window.location.href = '/logout'; // Redirect to your logout action\n  });\n}