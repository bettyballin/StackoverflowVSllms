$memcached = new Memcached();\n   $memcached->addServer('localhost', 11211);\n\n   // Check if the data is in memcached already\n   $data = $memcached->get('weather_data');\n\n   if (!$data) {\n       if ($xml = simplexml_load_file('http://www.weather.gov/data/current_obs/KBED.xml')) {\n           // Fetch and store weather data into variables\n           $data['temp'] = $xml->temp_f . ' Degrees';\n           $data['wind'] = $xml->wind_mph;\n           $data['wind_dir'] = $xml->wind_dir;\n           $data['gust'] = $xml->wind_gust_mph;\n           $data['time'] = $xml->observation_time;\n           $data['pres'] = $xml->pressure_in;\n           $data['weath'] = $xml->weather;\n\n           // Store data in memcached for 3600 seconds (1 hour)\n           $memcached->set('weather_data', $data, 3600);\n       } else {\n           echo 'unable to load XML file';\n           exit;\n       }\n   }\n\n   // Now you can use the cached data\n   echo '<p>Temperature: '.$data['temp'].'</p>';\n   echo '<p>Wind Speed: '.$data['wind'].' MPH</p>';