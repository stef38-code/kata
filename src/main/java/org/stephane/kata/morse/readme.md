# Le morse

Le but de ce Kata sera de code/decoder du morse

## Définition
`
Le code Morse international, ou l’alphabet Morse international, 
est un code permettant de transmettre un texte à l’aide de séries d’impulsions courtes et longues, 
qu’elles soient produites par des signes, une lumière, un son ou un geste.
`
[wiki](https://fr.wikipedia.org/wiki/Code_Morse_international)


## Les régles
* Tableau de correspondance

| Lettre | Code |
|:------:|:----:|
|   A    |  .-  |
|   B    | -... |
|   C    | -.-. |
|   D    | -..  |
|   E    |  .   |
|   F    | ..-. |
|   G    | --.  |
|   H    | .... |
|   I    |  ..  |
|   J    | .--- |
|   K    | -.-  |
|   L    | .-.. |
|   M    |  --  |
|   N    |  -.  |
|   O    | ---  |
|   P    | .--. |
|   Q    | --.- |
|   R    | .-.  |
|   S    | ...  |
|   T    |  -   |
|   U    | ..-  |
|   V    | ...- |
|   W    | .--  |
|   X    | -..- |
|   Y    | -.-- |
|   Z    | --.. |

| Chiffre |  Code  |
|:-------:|:------:|
| 0(zéro) | -----  |
| 1 (un)  | .----  |
|    2    | ..---  |
|    3    |  ..--  |
|    4    | ....-  |
|    5    | .....  |
|    6    | -....  |
|    7    | --... |
|    8    | ---..  |
|    9    | ----.  |

| Signes de ponctuation et symboles |   Code   |
|:---------------------------------:|:--------:|
|              .	Point              | 	.-.-.-	 |
|             ,	Virgule             | 	--..--	 |
|      ?	Point d’interrogation      |  ..--..  |
|           '	Apostrophe            |  .----.  |
|       !	Point d’exclamation       |  -.-.--  |
|      /	Barre oblique (slash)      |  -..-.   |
|      (	Parenthèse ouvrante	       |  -.--.   |
|      )	Parenthèse fermante	       |  -.--.-  |
|           &	Esperluette           |  .-...   |
|           :	Deux-points           |  ---...  |
|          ;	Point-virgule          |  -.-.-.  |
|           =	Signe égal            |  -...-   |
|           +	Signe plus            |  .-.-.   |
|  -	Signe moins ou trait d’union   |  -....-  |
|     _	Tiret bas (underscore)      |  ..--.-  |
| "	Guillemet droit (indifférencié) |  .-..-.  |
|         $	Symbole dollar          | ...-..-  |
|             @	Arobase             |  .--.-.  |

* temps entre deux lettres est la durée est identique à celle de 3 points ou d’1 tiret(1 blanc dans notre cas)
* temps entre deux mots est la durée est généralement identique à 7 points, parfois 5.(7 points dans notre cas)

## But
Le but de ce Kata est la réalisation d'un programme capable de décoder ou d'encoder en morse.

Mais aussi de mettre en action le TDD(test-driven development) autrement dit **le développement piloté par les tests**

Deux points de départ :
* 1 classe CodeInternational
  * Méthode encodage du text : toMorse(....) : String
  * Méthode décodage du code Morse: toText(....) : String

## Les étapes
### Encodage
#### Les lettres/caratères

1. Chaque Lettre de l'alphabet(EncodeLettreTest)
2. Chaque chiffre
3. Caractères spéciaux
#### Les Mots

|    Mot    |             Morse              |
|:---------:|:------------------------------:|
|   Lapin   |       .-.. .- .--. .. -.       |
| barbecue  | -... .- .-. -... . -.-. ..- .  |
| déjeuner  |   -.. . .--- . ..- -. . .-.    |
|20220128|..--- ----- ..--- ..--- ----- .---- ..--- ---..|
|,;:|--..-- -.-.- ---...|

#### Phrases

|     Phrases     |  Morse  |
|:---------------:|:-------:|
|    Au revoir    |.- ..- ....... .-. . ...- --- .. .-.|
|   Au secours    |.- ..- ....... ... . -.-. --- ..- .-. ...|
| Comment ça va ? |-.-. --- -- -- . -. - ....... .- ....... ...- .- ....... ..--..|

### Text

|                                                               Text                                                                |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          Morse                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
|:---------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| Une orange sur la table Ta robe sur le tapis Et toi dans mon lit Doux présent du présent Fraîcheur de la nuit Chaleur de ma vie.  |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ..- -. . ....... --- .-. .- -. --. . ....... ... ..- .-. ....... .-.. .- ....... - .- -... .-.. . ....... - .- ....... .-. --- -... . ....... ... ..- .-. ....... .-.. . ....... - .- .--. .. ... ....... . - ....... - --- .. ....... -.. .- -. ... ....... -- --- -. ....... .-.. .. - ....... -.. --- ..- -..- ....... .--. .-. . ... . -. - ....... -.. ..- ....... .--. .-. . ... . -. - ....... ..-. .-. .- .. -.-. .... . ..- .-. ....... -.. . ....... .-.. .- ....... -. ..- .. - ....... -.-. .... .- .-.. . ..- .-. ....... -.. . ....... -- .- ....... ...- .. . .-.-.-                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |

### Décodage

Repartir depuis le même jeux de données mais cette-ci en faisait du code Morse vers le text

## Le code source

|                                                 |                   Description                   |
|:-----------------------------------------------|:-----------------------------------------------:|
|  [CodeInternational](./CodeInternational.java)  |   Classe principale pour code/décode du morse   |
|             [business](./business)              |  Package de classe de recherche des coordances  |
|                [dicos](./dicos)                 |       Package contenant les dictionnaires       |
|             [register](./register)              |          Package du register des dico           |

## Le code source
L'ensemble des tests sont dans [tests unitaires](../../../../../../../src/test/java/org/stephane/kata/morse)

## outils en ligne
[text-to-morse](https://onlinetexttools.com/convert-text-to-morse)

[morse-to-text](https://onlinetexttools.com/convert-morse-to-text)
