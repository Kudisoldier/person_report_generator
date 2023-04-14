To run the project execute command in root of repository:
./gradlew run

Got data from https://github.com/Raven-SL/ru-pnames-list

Got cities from https://gist.github.com/helart/96225136a784f8a3987398be96456dce

For male person:
male_surname + male_name + male_name + "ович"

For female person:
male_surname + "а" + female_name + male_name + "овна"

Known bugs:
Не всегда такое склонение будет корректным, нужно делать склонятор, но в большинстве случаев результат ок.
