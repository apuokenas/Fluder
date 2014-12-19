Fluder
======

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/apuokenas/Fluder?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

`PI;N` (angl. `TL;DR`)

Masinio trumpųjų žinučių siuntimo programėlė "Fluder" skirta subombarduoti draugą, priešą ar net save patį. Arba dar geriau / blogiau - kokį nepažįstamąjį, kuris nė neįtarė, kad jo numeris taps lengvai / atsitiktinai išgalvojamu tau, *bombardieriau*, kursai negaili litų ant SMS'ų.

Programėlė "Fluder" yra licencijuota pagal ["Apache License"](http://choosealicense.com/licenses/apache-2.0) sąlygas, vadinasi, programinę įrangą galima laisvai:
* Naudoti bet kokiu tikslu.
* Modifikuoti.
* Platinti (tiek originalią, tiek modifikuotą versijas).
Vienintelė ribojanti sąlyga - privaloma išsaugoti autorines teises ir atsišaukimą (jei toks yra) bei nereikalauti jokių autorinių honorarų.

## Projekto techniniai niuansai

Šiame dokumente galite susipažinti su programėlės funkcionalumu.

Idėjų semtasi iš kyborgų korifėjaus Viliaus Kraujučio 2014 m. sausį vestų "Android" mokymų.

### Programavimo aplinkos įdiegimas

Jei norite prisidėti, tobulinant aplikaciją, turite lokaliai įsidiegti:

* Naujausią oficialią integruotą "Android" programavimo aplinką ["Android Studio"](http://developer.android.com/sdk/index.html).
* Projekto *buildinimo* automatizavimo įrankį ["Gradle" (v2.2.1)](http://services.gradle.org/distributions/gradle-2.2.1-all.zip).
* Programavimui "Java" kalba skirtą priemonę ["Java SE Development Kit 8"](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

### "Android" programėlės generavimas

Pasinaudojus "Android Studio" vedliu, iš "GitHub" kodo versijavimo sistemos galima parsiųsti programėlės struktūrą (kitaip tariant, susigeneruoti aplikacijos pagrindą):

`VCS` --> `Checkout from Version Control...` --> `GitHub`.

Atsidariusiame lange į "Vcs Version URL" laukelį įveskite:

`https://github.com/apuokenas/Fluder.git`,

o kaip "Parent Directory" nurodykite vietinį aplanką, kuriame talpinsite projekto failus.

P. S. Savo mašinoje reikia turėti git.exe bylą, kurios adresas įvedamas per "Settings" meniu:

`File` --> `Settings` --> `Version Control` --> `Git`.

Lauke "Path to Git executable" nurodomas kelias iki minėto failo. Pvz., jei esate "Windows" vartotojas:

`C:\Users\[Vartotojas]\AppData\Local\GitHub\PortableGit_[40_raidžių_ir_skaičių]\bin\git.exe`.

Kodo modifikacijas ir susijusius komentarus galite peržiūrėti "GitHub" [pakeitimų įrašuose](https://github.com/apuokenas/Fluder/commits).

### Vaizdo elementai

#### Elementų sąrašas

Pridėti teksto įvesties laukeliai:
* telefono numeriui,
* SMS pakartojimo skaičiui,
* SMS tekstui...

...ir mygtukas "Siųsti".

[IMG1_Placeholder]

#### Elementų pridėjimas

* Naudojami `GridLayout` arba `LinearLayout` išdėstymo būdai.
* Vaizdo komponentai (`Phone`, `Number`, `Multiline Text`) sudėti iš šoninės panelės.
* Nurodomi `id`, `text` ir `hint`.
* Tekstai *neįhardkodinami*, o sudedami į `strings.xml` failą.

[IMG2_Placeholder]

### Veikimo...

#### ...principas

Suprogramuoti mygtuką "Siųsti" taip, kad jį paspaudus, būtų išsiunčiama to paties turinio trumpoji žinutė nurodytu numeriu *n* kartų.

#### ...įgyvendinimas

* Pridėti mygtukui "Siųsti" `OnClickListener()` funkcija.
* Paimti visas reikšmes iš įvesties laukelių.
* Prasukti ciklą *n* kartų, kiekvieną kartą išsiunčiant SMS pranešimą.
