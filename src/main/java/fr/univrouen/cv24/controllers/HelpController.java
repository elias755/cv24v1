package fr.univrouen.cv24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpController {

    @GetMapping("/help")
    public String showHelpPage() {
        return "<!DOCTYPE html>\n" +
                "<html lang='fr'>\n" +
                "<head>\n" +
                "    <title>Aide - CV24</title>\n" +
                "	 <meta charset=\"utf-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Aide - CV24</h1>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>URL</th>\n" +
                "            <th>Méthode</th>\n" +
                "            <th>Résumé</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche la page d’accueil au format HTML du projet avec nom du projet, version, nom et prénom des membres du groupe et logo de l'université de Rouen. </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/help</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche la page contenant les informations d’aide. Retourne un document HTML valide. Cette page affiche une liste des opérations gérées par le service REST CV24. Chaque opération est décrite avec son URL, la méthode attendue, et un résumé détaillé de l'opération incluant les formats attendus et de retour.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/resume/xml</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche la liste des CV stockés au format XML. Retourne un flux XML contenant une liste de CV avec les informations suivantes pour chaque CV : ID (auto-incrémenté), Identité (Genre, Prénom, Nom), Objectif (avec le statut spécifié), Diplôme le plus élevé.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/resume</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche la liste des CV stockés au format HTML. Retourne une page HTML contenant une liste de CV avec les mêmes informations que /cv24/resume/xml.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/xml?id=&lt;id&gt;</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche le contenu complet du CV dont l’identifiant est transmis en paramètre au format XML. Retourne un flux XML conforme au schéma XSD cv24, comprenant un seul CV avec toutes les informations associées à cet ID. En cas d'ID incorrect, un message d'erreur au format XML est retourné.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/html?id=&lt;id&gt;</td>\n" +
                "            <td>GET</td>\n" +
                "            <td>Affiche le contenu complet du CV dont l’identifiant est transmis en paramètre au format HTML. Retourne une page HTML avec toutes les informations associées à cet ID. En cas d'ID incorrect, un message d'erreur au format HTML est retourné.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/insert</td>\n" +
                "            <td>POST</td>\n" +
                "            <td>Ajoute un CV dans la base de données. Transmet un flux XML conforme au schéma XSD. En cas de succès, le CV est ajouté à la base de données avec un ID généré automatiquement et un flux XML contenu cet ID et le status inserted est retourné. En cas d'échec, un flux XML contenant le status error et le detail INVALID ou DUPLICATED est retourné.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>/cv24/delete</td>\n" +
                "            <td>DELETE</td>\n" +
                "            <td>Supprime un CV de la base de données. Transmet l'identifiant du CV à supprimer. En cas de succès, un flux XML indiquant l'ID du CV supprimé ainsi qu'un status deleted est retourné. En cas d'échec, un flux XML contenant un status error est retourné.</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>";
    }
}
