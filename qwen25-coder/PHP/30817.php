$ftp_info = Doctrine_Query::create()\n    ->select('f.uid, f.home, s.identifier')\n    ->from('FtpUser f')\n    ->leftJoin('f.Submitter s')\n    ->where('f.uid = ?', 500)\n    ->fetchArray(); // Use fetchArray to get plain arrays\n\nprint $ftp_info[0]['uid'] ."\n";\nprint $ftp_info[0]['home'] ."\n";\nprint $ftp_info[0]['Submitter']['identifier'] ."\n"; // Note that 'description' should not be present here