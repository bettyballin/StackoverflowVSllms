-- This is more of an indirect check as MySQL doesn't have owners for databases in the same sense\n  SELECT USER(); -- Will show current db user; for db ownership check typically requires admin rights or DB meta tables/views not directly provided.