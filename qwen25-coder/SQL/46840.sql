DELETE FROM JOB\nWHERE job_id IN (\n    SELECT job_id \n    FROM job_person \n    GROUP BY job_id \n    HAVING COUNT(person_id) = 1 AND MAX(person_id) = 1\n);