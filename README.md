# hashCode2020

````

jour = 0
signup = false

pour chaque jours inf a max jours
   
    fonction trier les livres en score max->min
        associer score -> livre
        sortir liste livre trié par score

    fonction trier les librairies en score max->min
        somme des scores des livres presents
        

    pour chaque librairie classé ordre de score
        si etat == attente && signup == false && (signupdays-jours < joursMax)
            etat = signup 
            signupdays = signup

        si etat == signup && signupdays != 0
            signupdays --
            si signupdays == 0
                signup = false
                etat = scan

        si etat == scan
            pour nombre de livres par jour a scanner
                envoyer le plus interressant

        
````
