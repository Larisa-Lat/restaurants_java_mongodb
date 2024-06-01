# Оконное приложение по ресторанам Нью Йорка
## Задача проекта:

Написать оконное приложения для получение ресторанов в определенном районе и с определенной кухней.
Вывод ресторанов отсортирован  по убыванию средней оценки ресторанов.

## Привественное окно
<img width="182" alt="hello" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/e45dc44a-19d1-46d2-9275-c4228a3eaa88">

## Выбор района
Пользователь должен выбрать район из выпадающего списка.
Список районов получен из датабазы restaurants.

<img width="478" alt="Borough1" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/7d0b3fb3-f461-4b70-8ed3-53d81d21bbf2">

Если пользователь не выбрал район - то появиться подпись с прособой выбрать.

<img width="482" alt="Borough2" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/5ea0104c-fc91-426e-b923-de2ddcfe868a">

## Выбор кухни
Пользователь должен выбрать кухню из выпадающего списка кухнь в районе, выбранном пользвателем ранее.

<img width="478" alt="Cuisine1" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/6bc1244b-6353-4711-ae9a-4d23153548a7">

Аналогично как в предыдущем окне, если пользователь не выбрал кухню - то появиться подпись с прособой выбрать.

<img width="476" alt="Cuisine2" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/adecee87-6b0e-479d-aca3-08c4e2b9de4d">

## Вывод ресторанов
Вывод пользователю таблицы ресторанов в выбранном ранее районе и кухне.
Таблица имеет колонки:
- название ресторана
- средний бал ресторана
- район 
- кухня
- улица
- номер здания

Таблица отсортирована в порядке убывания по колонке средний бал ресторана.

<img width="832" alt="Restaurants" src="https://github.com/Larisa-Lat/restaurants_java_mongodb/assets/80693001/80ed432d-ec6c-44f0-9b47-c7867323b178">
