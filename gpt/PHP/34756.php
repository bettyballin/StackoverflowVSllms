<?php\n$date = new DateTime('2009-07-01 12:00:00', new DateTimeZone('America/Los_Angeles'));\n$offset = $date->getOffset() / 3600;\necho $offset;\n?>