# Демонстрация многопоточности на примере взаимодействия окон
Представлено 5 видов окон (на каждом расположны различные графические компоненты с раздичными функциясми).
Взаимодействие пользователя с окнами осуществляется в основном потоке.
После нажатия сочетания клавиш Ctl+A создается новый поток, в котором все существующие окна начинают вращаться по часовой стрелке.
Чтобы усыпить поток, необходимо нажать сочетание клавиш Ctrl+B.