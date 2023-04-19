# UCE Génie Logiciel Avancé : Techniques de tests

TP de SAMSON Manon,
M1 IA Classique

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)
[![codecov](https://codecov.io/gh/PikaManon/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=GB7410C63N)](https://codecov.io/gh/PikaManon/ceri-m1-techniques-de-test)
![Checkstyle](https://circleci-tasks-prod.s3.us-east-1.amazonaws.com/storage/artifacts/44be176a-cd40-46b3-b13c-b52dffce4522/6e942ae4-845d-46a2-b678-2d35133d7926/0/artifacts3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAQVFQINEODCEKOHNF%2F20230419%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230419T102644Z&X-Amz-Expires=60&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEHsaCXVzLWVhc3QtMSJHMEUCIQDNo8FwekpzlJM7xCUilv%2B5MRPh8m9hoN4PafVLCjscrAIgQf3ipqMp3Baij8OQTOE6IiwkjOS2dDraxeDeV01MZ7oqqwIIcxADGgwwNDU0NjY4MDY1NTYiDJHuE0d0KGM88%2BUsqyqIAtDaKjMtm49A%2F%2FMgb6XsmwTC6%2Bl9gXEHXqyxm4UBHYqRmxCpKK9mk5VlI8u6efBjvFgfmPJocMZOqZf5RgkowcRDHQE37QmzuMvW1IFVByRynDtpAnNc7b9uoKhiY%2FAyxE1Bzc2ZIWFVvj%2B%2BMB50FgMp1Rt6GGyes9LSSkyj1Jko1MUP7hydSQpnSlUy8%2B0uDXJcHNqCm5BRjQO%2FcvNL37ZANCqyD99LHzWCX%2FPWrPnew9fPIrbmGdzDkXdUpo75EHiXEOAF8uPSCqBMFok1xwceS%2FWZvIiZC8NeSqXTHrmcaC1CsHM0HlT5Sy0Eci7OQijqTZVFI0hj2x56xx3QF0bN60J5PaezWDClgf%2BhBjqdAd8GrfT7PBV9Hk8gtyclzmLRtGOx77EgFklKgMO8Jtqi0bczgL2hYP20CqCAgJC%2BWKnOEFTdb41wyZH55AdjGecbNdW2L2HvX7Cy%2BKefLWz7V4%2FXaHeEse78abmDG%2BdSQZT68vqWAFyzeYoTDJYIJD4k7gvb%2BZfpE1MUxX92Fmvvt2xynnRU0OQot2tANRkjaRaEDgbk5bGDLi3oUWY%3D&X-Amz-SignedHeaders=host&x-id=GetObject&X-Amz-Signature=b283a68a973b5c08be8b9f423875d391d82f1fbc7057f9657c56c55e91d8bad3)
## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Le projet consiste à mettre en place un outil d’analyse statistique pour le jeu Pokémon GO.  
Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 1ère séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu, le projet dans son intégralité doit être déposé sur la plateforme.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
