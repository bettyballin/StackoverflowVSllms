SELECT /*+ INDEX(sometable bar_index) */ * FROM sometable WHERE foo='hello' AND bar='world';