<?php\nwhile(true) {\n   jobs = getListOfJobsFromDatabase();  // get the jobs from the databbase\n   foreach (jobs as job) {\n      processAJob(job); // do whatever needs to be done for the job\n      deleteJobFromDatabase(job); //remember to delete the job once its done!\n   }\n   sleep(60); // sleep for a while so it doesnt thrash your database when theres nothing to do\n}\n?>