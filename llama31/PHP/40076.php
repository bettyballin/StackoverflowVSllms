$offset = $_POST['offset']; // or $_GET['offset'] if using a query string\n$viewerTime = new DateTime('now', new DateTimeZone('UTC'));\n$viewerTime->modify("+$offset minutes");