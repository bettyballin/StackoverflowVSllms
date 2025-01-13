$sql = "SELECT ven.venue_name as 'Venue', COUNT(vol.id) as 'Number Of \nVolunteers' FROM venues ven JOIN volunteers_2009 vol ON \n(ven.id=vol.venue_id) GROUP BY ven.venue_name ORDER BY ven.venue_name ASC";