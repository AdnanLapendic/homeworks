TASK #1 – OBICNA CHAT APLIKACIJA

Napraviti mreznu aplikaciju na kojoj kontinualno mogu komunicirati, tj. chatati, Client i Server. Ovo 
smo vec uradili. Server posalje neku poruku Clientu-u, pa zatim Client Server-u, pa ponovo Server 
salje Client-u, itd. 

Ovaj put dodati GUI na to tako da postoji polje gdje se unosi poruka, kao i neka komponenta koja 
prikazuje dosadasnje poruke. 

TASK #2 – DODATNE FUNKCIJE

Prethodnoj aplikaciji dodati par funkcionalnosti:
	Ukoliko se posalje poruka tipa /web www.google.ba onda se na drugom racunaru treba 
otvoriti browser i pokrenuti navedena stranica (u ovom slucaju google.ba).
	Ukoliko se posalje poruka tipa /open C:/Program Files/Games/Minesweeper.exe onda
se na drugom racunaru treba pokrenuti dati file (u ovom slucaju igra minesweeper). Dati 
direktorij i file se nalaze na drugom racunaru, ne na prvom.
	Ukoliko se posalje poruka tipa /delete C:/Program Files/Games/Minesweeper.exe
onda se treba obrisati dati file sa drugog racunara.
	Ukoliko se posalje poruka tipa /list C:/Documents onda ce drugi racunar poslati prvom 
spisak direktorija koji se nalaze na datoj lokaciji (u ovom slucaju Documents folder sa C diska). 
Zatim, prvi racunar ispisuje sebi taj spisak direktorija.