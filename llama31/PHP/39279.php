$base64String = '/9j/4AAQSkZJRgABAgEASABIAAD/4QxrRXhpZgAATU0AKgAAAAgABwESAAMAAAABAAEAAAEaAAUA...';\n\n$decodedData = base64_decode($base64String);\n\n$file = 'trans2.jpg';\nfile_put_contents($file, $decodedData);