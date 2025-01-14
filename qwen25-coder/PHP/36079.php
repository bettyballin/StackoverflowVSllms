class Your_Model_Schedule extends Zend_Db_Table_Abstract {\n    protected $_name = 'sessions';\n\n    public function getCourseSchedule($courseId)\n    {\n        $selectLocations = $this->select()\n            ->from('locations', ['locationid'])\n            ->joinInner('sessions', 'locations.locationid = sessions.locationid')\n            ->where('sessions.courseid = ?', $courseId)\n            ->group('locations.locationid');\n\n        $locations = $this->fetchAll($selectLocations);\n\n        $schedule = [];\n        foreach ($locations as $location) {\n            $locationData = [\n                'locationid' => $location->locationid,\n                'sessions'   => []\n            ];\n\n            $selectSessions = $this->select()\n                ->from('sessions')\n                ->where('sessions.locationid = ?', $location->locationid)\n                ->where('sessions.courseid = ?', $courseId);\n\n            $sessions = $this->fetchAll($selectSessions);\n            foreach ($sessions as $session) {\n                $sessionId = $session->sessionid;\n                $sessionData = [\n                    'sessionid' => $sessionId,\n                    'dates'     => []\n                ];\n\n                // Now get the dates\n                $selectDates = new Zend_Db_Select($this->_db);\n                $selectDates->from('dates', ['date'])->where('dates.sessionid = ?', $sessionId);\n\n                $dates = $selectDates->query()->fetchAll();\n                foreach ($dates as $date) {\n                    $sessionData['dates'][] = $date['date'];\n                }\n\n                $locationData['sessions'][] = $sessionData;\n            }\n            $schedule[] = $locationData;\n        }\n\n        return $schedule;\n    }\n}