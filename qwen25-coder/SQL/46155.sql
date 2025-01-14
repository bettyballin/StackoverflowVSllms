SELECT \n    A.ID,\n    A.Name,\n    GROUP_CONCAT(DISTINCT B.Name SEPARATOR ', ') AS Linked_B_Names\nFROM \n    A\nLEFT JOIN \n    A_B_Link ON A.ID = A_B_Link.A_ID\nLEFT JOIN \n    B ON A_B_Link.B_ID = B.ID\nGROUP BY \n    A.ID, A.Name;