SELECT * \nFROM appts \nWHERE timeStart < '$timeEnd' \nAND timeEnd > '$timeStart' \nAND dayappt = '$boatdate'