<form [action, method etc]>\n  <table>\n  <?php \n    foreach($dataSet as $dataRow) : \n  ?>\n      <tr>\n         <td>\n            <input type="checkbox" name="dataRow[]" value="<?=$dataRow['id']?>"/>\n         </td>\n         [Additional details about datarow here]\n      <tr>\n  <?php \n    endforeach; \n  ?>\n  </table>\n</form>