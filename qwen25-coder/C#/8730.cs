<% foreach (XElement segnalazione in ((XElement)ViewData["collezioneSegnalazioni"]).Elements("dossier")) { %>\n    <tr>\n        <td><%= Html.Encode(segnalazione.Element("NUM_DOSSIER").Value) %></td>\n        <td><%= Html.Encode(segnalazione.Element("ANAG_RAGSOC_CGN").Value) %></td>\n        <td><%= Html.Encode(segnalazione.Element("ID_RIFATT_SEGN0").Value) %></td>\n        <td><%= Html.Encode(segnalazione.Element("FLG_STATUS").Value) %></td>\n        <td>\n            <% \n                var dtAccadimentoElement = segnalazione.Element("DT_ACCADIMENTO");\n                if (dtAccadimentoElement != null)\n                { %> \n                    <%= Html.Encode(dtAccadimentoElement.Value) %>\n                <% } else { %> \n                    <%= "" %>\n                <% } \n            %>\n        </td>\n        <td><%= Html.Encode(segnalazione.Element("COD_RAMO_LUNA").Value) %></td>\n    </tr>\n<% } %>