
//On suppose que le framework s'occupe des fonctions InputReader, Shuffle&Sort et OutputWriter
function Map(cle, valeur, contexte=[]){
	//Séparation des tuples par la virgule
  let ligne = valeur.split(",")
  
  //Parcours des lignes du tableau 'contexte': pour chaque cle2
  for(cle2 in ligne){
	//Ajoute a notre tableau de valeurs le couple composé d'une cle 'cle' peuplée par cle2 et d'une valeur composée d'un numero de colonne 'colNum' et d'une valeur peuplée par chaque case ligne[i])
    contexte.push({
      cle : cle2,
      valeurFinale : {
        col_num : cle,
        valeurTemp : ligne[cle2]  
      }
    })
  }
}


function Reduce(cle, valeur, contexte=[]){
   //on declare valeurBis un nouveau tableau de valeurs
  let valeurBis = []
  // Pour chaque cle dans valeur, on peuple notre nouveau tableau de valeur 'valeurBis' par le pivot du tableau initial.
  for (cle in valeur){
    valeurBis[valeur[cle].col_num] = valeur[cle].valeurTemp
  }
  //on push le resultat dans le tableau de resultat final 'contexte'
  contexte.push({
    cle : cle,
    valeurFinale : valeurBis
  })
}