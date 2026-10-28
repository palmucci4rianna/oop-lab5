# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory
mkdir 54-branching

### Si inizializzi un repository Git dentro la cartella suddetta.
cd 54-branching
git init

### Si osservi lo stato del repository
git status

### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
nano HelloWorld.java
cat HelloWorld.java

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
git status

### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "add HelloWorld.java"

### Si compili il file Java e si verifichi lo stato del repository
javac HelloWorld.java
./HelloWorld.java

### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
nano .gitignore
cat .gitignore
*.class

### Si osservi lo stato del repository
git status

### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git add .gitignore
git commit -m "add .gitignore"
git status

### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
nano .gitattributes
* text=auto eol=lf
*.[cC][mM][dD] text eol=crlf
*.[bB][aA][tT] text eol=crlf
*.[pP][sS]1 text eol=crlf
git add .gitattributes  
git commit -m "add .gitattributes"
 
### Si osservi la storia del repository usando `git log --all --graph`
* commit 27e97ad1b42f824f3526be00639d65317fae5224 (HEAD -> main)
| Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
| Date:   Fri Oct 24 20:50:40 2025 +0200
| 
|     add .gitignore
| 
* commit bdf7a796fbc551b7019fba199a13d6affac6a2f6
  Author: Arianna Palmucci <arianna.palmucci@studio.unibo.it>
  Date:   Fri Oct 24 20:47:31 2025 +0200
  
      add HelloWorld.java
      
### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`
git status

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
touch Mistake.java
git add Mistake.java
git commit -m "add Mistake.java"

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica
git mv Mistake.java ToDelete.java
git add Todelete.java
git commit -m "rename Mistake.java in ToDelete.java"

### Si elimini `ToDelete.java` e si registri la modifica in un commit
rm ToDelete.java
git add ToDelete.java
git commit -m "removed ToDetele.java"

### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`
git log --oneline
5bf1a4f (HEAD -> main) removed ToDetele.java
4cdeea7 rename Mistake.java in ToDelete.java
a85f215 add Mistake.java
06edd3d add .gitattributes
27e97ad add .gitignore
bdf7a79 add HelloWorld.java

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout a85f215 -- Mistake.java
git add Mistake.java
git commit -m "re-add Mistake.java"

### Si rimuova il file ripristinato e si ripulisca lo stage
rm Mistake.java
git add Mistake.java
git commit -m "re-delete Mistake.java"

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git checkout a85f215

### Si crei un nuovo branch di nome `experiment` e si agganci la `HEAD` al nuovo branch
git branch experiment
git checkout experiment

git branch -v
* experiment a85f215 add Mistake.java
  main       118ed3b re-delete Mistake.java

git log --oneline --graph --decorate --all
* 118ed3b (main) re-delete Mistake.java
* 2ee1f99 re-add Mistake.java
* 5bf1a4f removed ToDetele.java
* 4cdeea7 rename Mistake.java in ToDelete.java
* a85f215 (HEAD -> experiment) add Mistake.java
* 06edd3d add .gitattributes
* 27e97ad add .gitignore
* bdf7a79 add HelloWorld.java

### Si crei un file README.md con contenuto a piacere, e si faccia un commit che lo includa
nano README.md
git add README.md
git commit -m "add README.md"

### Si torni sul branch master e si elenchino i branch disponibili
git checkout main
git branch -v

### Si unisca il branch experiment al branch master (si faccia un merge in cui experiment viene messo dentro master, e non viceversa)
git merge experiment
Merge made by the 'ort' strategy.
 README.md | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 README.md

### Si osservi la storia del repository
git log --oneline --graph --decorate --all
*   171fb72 (HEAD -> main) Merge branch 'experiment' merge experiment into main
|\  
| * 6a6472d (master, experiment) add README.md
* | 118ed3b re-delete Mistake.java
* | 2ee1f99 re-add Mistake.java
* | 5bf1a4f removed ToDetele.java
* | 4cdeea7 rename Mistake.java in ToDelete.java
|/  
* a85f215 add Mistake.java
* 06edd3d add .gitattributes
* 27e97ad add .gitignore
* bdf7a79 add HelloWorld.java

### ari - eliminati i branch accessori 
git merge master
Già aggiornato.
git branch -d master
Branch master eliminato (era 6a6472d).
git branch -d experiment
Branch experiment eliminato (era 6a6472d).
git branch
* main
