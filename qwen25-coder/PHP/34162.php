$query = "SELECT produto.*, pt.* \n          FROM `produto` \n          INNER JOIN `pt` ON produto.refPT = pt.ref \n          WHERE produto.refPT IN (SELECT `idProduto` \n                                  FROM `amb_prod` \n                                  WHERE idAmbiente='$ambId');";