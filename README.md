# 🏋️ Fitness Tracker - Database Model

Ovaj repozitorijum sadrži bazu podataka za fitness aplikaciju, uključujući SQL skriptu za kreiranje tabela i Java POJO klase.

## 📊 ER Dijagram
![ER Dijagram](er_diagram.png)

## 📂 Struktura baze podataka
Baza podataka sadrži sledeće tabele:

- **users** - Informacije o korisnicima (ime, prezime, email, itd.).
- **muscle_group** - Grupe mišića (npr. "Noge", "Ruke").
- **muscle** - Pojedinačni mišići, povezani sa grupama mišića.
- **exercise** - Vežbe sa opisima.
- **exercise_muscle** - Many-to-Many veza između vežbi i mišića.
- **workout** - Programi vežbanja sa vremenom trajanja.
- **workout_exercise** - Many-to-Many veza između programa vežbanja i vežbi.
- **user_progress** - Napredak korisnika (ponavljanja, težina, datum).

## 🚀 Tehnologije
- **PostgreSQL** - Baza podataka
- **Java** - Backend (POJO modeli)
- **IntelliJ IDEA** - Razvojno okruženje

## 📥 Instalacija
1. Klonirajte repozitorijum:
   ```sh
   git clone https://github.com/k0ntrol/myfitness.git


## 📝 Autor
👤 *Filip Cokovski*  
📧 *fcokovski@gmail.com* 
