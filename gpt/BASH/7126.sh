sudo docker pull httpd\n   sudo docker stop my-apache-server\n   sudo docker rm my-apache-server\n   sudo docker run -d --name my-apache-server -p 80:80 -v /path/to/your/web/files:/usr/local/apache2/htdocs/ httpd