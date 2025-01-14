SELECT DISTINCT a.user, pp.courriel\nFROM acces a\nJOIN activite_sport ac ON EXISTS (\n    SELECT 1 \n    FROM activite act \n    WHERE act.activite_id = ac.activite_id \n      AND act.is_cron = 1 \n      AND act.cron_processed = 0\n)\nLEFT JOIN acces_profil_sport ap ON ap.id = a.id\nJOIN profil_perso pp ON pp.id = a.id\nJOIN activite_region ar ON ar.region_id = pp.region_id\nWHERE ac.sport_id IS NOT NULL AND ar.activite_id IN (\n    SELECT act.activite_id \n    FROM activite act \n    WHERE act.is_cron = 1 AND act.cron_processed = 0\n)