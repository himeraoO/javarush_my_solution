package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Operation operation = Operation.LOGIN;
            CommandExecutor.execute(operation);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException ignored) {
            ConsoleHelper.printExitMessage();
        }
    }
}
/*
CashMachine (15)
1. В CashMachine создай константу - путь к ресурсам.
public static final String RESOURCE_PATH;
Отрефакторь загрузку всех ResourceBundle с учетом RESOURCE_PATH.

2. В классе CashMachine не должно быть инициализации ResourceBundle.
Вынеси из CashMachine сообщение о выходе в ConsoleHelper, назови метод printExitMessage.

3. Это всё! Красоту можешь наводить самостоятельно. Тестов на этот пункт не будет.
Например:
3.1. Исправить выводимые тексты.
3.2. Добавить ресурсы для нескольких локалей. Например, еще и для русской.
3.3. Добавить валидацию вводимых номиналов.

Твои достижения:
1. разобрался с паттерном Command.
2. подружился с Жадным алгоритмом.
3. познакомился с локализацией.
4. стал больше знать и уметь.
5. увидел, как раскладывать задачу на подзадачи.
6. продвинулся на шаг ближе к работе джава программистом.
7. решил одно из тестовых заданий, которое дают на собеседовании. Только тсссс, никому об этом не говори :).
Если когда-то тебе дадут такое задание, то не копируй это решение, а сделай свое по аналогии.

Поздравляю!


Requirements:
1. Класс CashMachine должен содержать public static final поле RESOURCE_PATH типа String.
2. Класс ConsoleHelper должен содержать public static void метод printExitMessage().
3. Поздравляю, это все на этот уровень!
 */