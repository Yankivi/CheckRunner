# CheckRunner

## Введение
CheckRunner - проект, реализующий вывод чека, рассчитанного по входным параметрам, в консоль и текстовый файл. 
Используемый стек: Java 17, IntelliJ IDE, GitHub.
## Инструкция по использованию
Передача входных параметров может происходить 2 способами:
1. Передача непосредственно в косоль (java RunnerClassName <набор_параметров>, где набор параметров в формате itemId-quantity card-cardNumber (itemId - идентификатор товара, quantity - его количество, cardNumber - номер скидочной карты)).
2. Запись в файл CheckInputFile.txt в формате itemId-quantity card-cardNumber.

Набор параметров card-cardNumber - не обязателен.

В базе данных предусмотрены акционные товары. Если их колличество превышает 5 - к этой позиции применяется скидка 10%.

## Тестовые данные
Карты: 
Card Number - Discount  
1000 - 12%  
1111 - 5%  
1221 - 0%  
1311 - 50%  
1467 - 3%  
1581 - 0%  
1670 - 3%  
1739 - 20%  
1888 - 0%  
1956 - 14%  

Товары:
Name - itemID - isOnSale - Price  
Banana   -  1   -  false -   2.45$   
Pineapple - 2    - false  -  3.20$  
Orange    - 3    - true   -  2.90$   
Watermelon - 4   -  false  -  4.50$  
Cherry    - 5    - false   - 6.30$   
Grapefruit - 6   -  false  -  3.00$  
Strawberry - 7   -  true   -  7.12$  
Lemon      - 8   -  true   -  2.80$     
Peach      - 9   -  false  -  5.61$   
Pear      - 10   -  true   -  1.99$   

## Нереализованные функции
На данный момент к архитектуре проекта не применены паттерны проектирования (Factory, Builder, Decorator). Не реализована сборка проекта с помощью gradle, обраотка исключений, а также не написаны юнит-тесты.
