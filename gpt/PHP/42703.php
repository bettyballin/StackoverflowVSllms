// Before\n   $username = $username; // This would have worked with register_globals\n\n   // After\n   $username = $_POST['username']; // Assuming the value comes from a POST request