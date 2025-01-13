SELECT SUM(b134_nettpay) AS Total, b134_rmcid, b134_recdate \nFROM  B134HREC \nWHERE datediff (dd, (SELECT MAX(b134_recdate) FROM B134HREC), getdate()) > 90\nGROUP BY b134_rmcid, b134_recdate \nORDER BY b134_recdate DESC, b134_rmcid