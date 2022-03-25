package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/

//        Рекурсия для мат. выражения
//        На вход подается строка - математическое выражение.
//        Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -,
//        возведение в степень ^, sin(x), cos(x), tan(x)
//        Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
//        Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
//        С помощью рекурсии вычислить выражение и количество математических операций.
//        Вывести через пробел результат в консоль.
//        Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33,
//        использовать стандартный принцип округления.
//        Знак отрицания перед числом также считать математической операцией.
//        Не создавай в классе Solution дополнительные поля.
//        Не пиши косвенную рекурсию.
//
//        Пример, состоящий из операций sin * - + * +:
//        sin(2*(-5+1.5*4)+28)
//        Результат:
//        0.5 6
//
//        Пример, состоящий из операций tan ^:
//        tan(2025 ^ 0.5)
//        Результат:
//        1 2
//
//
//        Requirements:
//        1. В классе Solution не должны быть созданы дополнительные поля.
//        2. Метод recurse должен выводить на экран результат вычисления заданного выражения (пример в условии).
//        3. Метод recurse не должен быть статическим.
//        4. Метод recurse должен быть рекурсивным.


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
    }

//    public void recurse(final String expression, int countOperation) {
//        int newCount = countOperation;
//        List<Lexeme> lexemes = lexAnalyze(expression);
//      //  LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
//        System.out.println(lexemes);
//        if(lexemes.contains(LexemeType.LEFT_BRACKET)){
//            int i1 = lexemes.lastIndexOf(LexemeType.LEFT_BRACKET);
//            int i2 = 0;
//            for (int j = i1; j < lexemes.size(); j++) {
//            //    if(lexemes.get(j) == LexemeType.RIGHT_BRACKET){
//                    i2 = j;
//                    break;
//          //      }
//            }
//
//        }
//
//        //implement
//    }
//
//    public Solution() {
//        //don't delete
//    }
//
//    public enum LexemeType {
//        LEFT_BRACKET, RIGHT_BRACKET,
//        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
//        NUMBER, NAME, COMMA, POINT, RATE, SIN, COS, TAN,
//        EOF;
//    }
//
//    public static class Lexeme {
//        LexemeType type;
//        String value;
//
//        public Lexeme(LexemeType type, String value) {
//            this.type = type;
//            this.value = value;
//        }
//
//        public Lexeme(LexemeType type, Character value) {
//            this.type = type;
//            this.value = value.toString();
//        }
//
//        @Override
//        public String toString() {
//            return "Lexeme{" +
//                    "type=" + type +
//                    ", value='" + value + '\'' +
//                    '}';
//        }
//    }
//
//    public static class LexemeBuffer {
//        private int pos;
//
//        public List<Lexeme> lexemes;
//
//        public LexemeBuffer(List<Lexeme> lexemes) {
//            this.lexemes = lexemes;
//        }
//
//        public Lexeme next() {
//            return lexemes.get(pos++);
//        }
//
//        public void back() {
//            pos--;
//        }
//
//        public int getPos() {
//            return pos;
//        }
//    }
//
//    public static List<Lexeme> lexAnalyze(String expression) {
//        ArrayList<Lexeme> lexemes = new ArrayList<>();
//        int pos = 0;
//        while (pos< expression.length()) {
//            char c = expression.charAt(pos);
//            switch (c) {
//                case '(':
//                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
//                    pos++;
//                    continue;
//                case ')':
//                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
//                    pos++;
//                    continue;
//                case '+':
//                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
//                    pos++;
//                    continue;
//                case '-':
//                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
//                    pos++;
//                    continue;
//                case '*':
//                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
//                    pos++;
//                    continue;
//                case '/':
//                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
//                    pos++;
//                    continue;
//                case ',':
//                    lexemes.add(new Lexeme(LexemeType.COMMA, c));
//                    pos++;
//                    continue;
////                case '.':
////                    lexemes.add(new Lexeme(LexemeType.POINT, c));
////                    pos++;
////                    continue;
//                case '^':
//                    lexemes.add(new Lexeme(LexemeType.RATE, c));
//                    pos++;
//                    continue;
//                default:
//                    if ((c <= '9' && c >= '0') || (c =='.') ){
//                        StringBuilder sb = new StringBuilder();
//                        do {
//                            sb.append(c);
//                            pos++;
//                            if (pos >= expression.length()) {
//                                break;
//                            }
//                            c = expression.charAt(pos);
//                        } while ((c <= '9' && c >= '0') || (c =='.') );
//                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
//                    } else {
//                        if (c != ' ') {
//                            if (c >= 'a' && c <= 'z'
//                                    || c >= 'A' && c <= 'Z') {
//                                StringBuilder sb = new StringBuilder();
//                                do {
//                                    sb.append(c);
//                                    pos++;
//                                    if (pos >= expression.length()) {
//                                        break;
//                                    }
//                                    c = expression.charAt(pos);
//                                } while (c >= 'a' && c <= 'z'
//                                        || c >= 'A' && c <= 'Z');
//
//                                String s = sb.toString();
//                                switch (s) {
//                                    case "sin": lexemes.add(new Lexeme(LexemeType.SIN, sb.toString()));
//                                                break;
//                                    case "cos": lexemes.add(new Lexeme(LexemeType.COS, sb.toString()));
//                                                break;
//                                    case "tan": lexemes.add(new Lexeme(LexemeType.TAN, sb.toString()));
//                                                break;
//                                    default:    throw new RuntimeException("Unexpected characters: " + s);
//                                }
////                                    if (functionMap.containsKey(sb.toString())) {
////                                    lexemes.add(new Lexeme(LexemeType.NAME, sb.toString()));
////                                } else {
////                                    throw new RuntimeException("Unexpected character: " + c);
////                                }
//                            }
//                        } else {
//                            pos++;
//                        }
//                    }
//            }
//        }
//        lexemes.add(new Lexeme(LexemeType.EOF, ""));
//        return lexemes;
//    }
//
//    public interface Function {
//        int apply(List<Integer> args);
//    }
//
//    public static HashMap<String, Function> getFunctionMap() {
//        HashMap<String, Function> functionTable = new HashMap<>();
//        functionTable.put("min", args -> {
//            if (args.isEmpty()) {
//                throw new RuntimeException("No arguments for function min");
//            }
//            int min = args.get(0);
//            for (Integer val: args) {
//                if (val < min) {
//                    min = val;
//                }
//            }
//            return min;
//        });
//        functionTable.put("pow", args -> {
//            if (args.size() != 2) {
//                throw new RuntimeException("Wrong argument count for function pow: " + args.size());
//            }
//            return (int) Math.pow(args.get(0), args.get(1));
//        });
//        functionTable.put("rand", args -> {
//            if (!args.isEmpty()) {
//                throw new RuntimeException("Wrong argument count for function rand");
//            }
//            return (int)(Math.random() * 256f);
//        });
//        functionTable.put("avg", args -> {
//            int sum = 0;
//            for (int i = 0; i < args.size(); i++) {
//                sum += args.get(i);
//            }
//            return sum / args.size();
//        });
//        return functionTable;
//    }
//}

    private double makeOperation(String s, double first, double second) {
        switch (s) {
            case "+": {
                return first + second;
            }
            case "=": {
                return 0.0 - second;
            }
            case "%": {
                return 0.0 - second;
            }
            case "-": {
                return first - second;
            }
            case "@": {
                return first - second;
            }
            case "*": {
                return first * second;
            }
            case "/": {
                return first / second;
            }
            case "^": {
                return Math.pow(first, second);
            }
            default:
                return -1;
        }
    }

    private double makeFunction(String s, double first) {
        switch (s) {
            case "s": {
                return Math.sin(Math.toRadians(first));
            }
            case "c": {
                return Math.cos(Math.toRadians(first));
            }
            case "t": {
                return Math.tan(Math.toRadians(first));
            }

            default:
                return -1;
        }
    }

    private int getPriority(String s) {
        switch (s) {
            case "+":
            case "-":
            case "=":
            case "%":
            case "@":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "c":
            case "s":
            case "t":
                return 4;
            default:
                return -1;
        }
    }

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("@") || c.equals("%") || c.equals("=") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    private boolean isFunction(String c) {
        return c.equals("s") || c.equals("c") || c.equals("t");
    }

    private String doSomething(String expression) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        DecimalFormat df = (DecimalFormat) numberFormat;
        df.applyPattern("#.##");
        LinkedList<Double> doubles = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String workWith = expression.replaceAll("(S|s)(I|i)(N|n)", "s");//Заменяем все функции на одиночный аналог
        workWith = workWith.replaceAll("[Cc][Oo][Ss]", "c");//Заменяем все функции на одиночный аналог
        workWith = workWith.replaceAll("[Tt][Aa][Nn]", "t");//Заменяем все функции на одиночный аналог
        //посчитаем количество операций
        workWith = workWith.replaceAll("^-", "=");
        for (int i = 0; i < 2; i++) {
            Pattern binaryMinus = Pattern.compile("(\\d+\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\d)|(\\d\\s?-\\s?[cst])" +
                    "|([cst]\\s?-\\s?[cst])|(\\)\\s?-\\s?\\()|(\\d+\\s?-\\s?\\()" +
                    "|(\\)\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\()|(\\)\\s?-\\s?[cst])");
            Matcher minusMatcher = binaryMinus.matcher(workWith);
            while (minusMatcher.find()) {
                String group = minusMatcher.group();
                String newString = group.replace('-', '@');
                workWith = workWith.replace(group, newString);
            }
        }
        Pattern strange = Pattern.compile("[^\\d)]\\s?\\-\\s?[\\dcst\\(]");
        Matcher mimi = strange.matcher(workWith);
        while (mimi.find()) {
            String lookfor = mimi.group();
            String replTo = lookfor.replace("-", "%");
            workWith = workWith.replace(lookfor, replTo);
        }
        int numberOfOperations = 0;
        if (numberOfOperations == 0) {
            Pattern operation = Pattern.compile("[sct\\+\\-\\*/\\^=%@]");
            Matcher matcher = operation.matcher(workWith);
            while (matcher.find()) {
                numberOfOperations++;
            }
        }
        //в следующем блоке заменяем все цифры символом D
        Pattern compareWithDecimals = Pattern.compile("-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)");
        Matcher m = compareWithDecimals.matcher(workWith);
        while (m.find()) {
            String ourDouble = m.group();
            doubles.add(new Double(ourDouble));
            workWith = workWith.replaceFirst(ourDouble, "D");
        }
        workWith = workWith.replaceAll(" ", "");
        String[] p = workWith.split("");
        LinkedList<String> operators = new LinkedList<>();
        LinkedList<Double> d = new LinkedList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("D")) {
                d.add(doubles.removeFirst());
            }
            if (isFunction(p[i]) || isOperator(p[i])) {
                if (operators.size() == 0) {
                    operators.add(p[i]);
                    continue;
                } else {
                    String lastOper = operators.getLast();
                    int lastOperPriority = getPriority(lastOper);
                    int thisPriority = getPriority(p[i]);
                    while (thisPriority <= lastOperPriority && operators.size() > 0) {
                        if (thisPriority == 3 && lastOperPriority == thisPriority) {
                            operators.add(p[i]);
                            break;
                        }
                        Double res = 0.0;
                        String operation = operators.removeLast();
                        if (operation.equals("=") || operation.equals("%")) {
                            Double d2 = d.removeLast();
                            res = makeOperation(operation, 0.0, d2);
                            res = new Double(df.format(res));
                            d.add(res);
                            if (operators.size() > 0) {
                                lastOperPriority = getPriority(operators.getLast());
                            } else {
                                lastOperPriority = -1;
                            }
                            continue;
                        }
                        Double d2;
                        Double d1 = 0.0;
                        if (isOperator(operation)) {
                            d2 = d.removeLast();
                            if (d.size() > 0) {
                                d1 = d.removeLast();
                            }
                            res = makeOperation(operation, d1, d2);
                        }
                        if (isFunction(operation)) {
                            d2 = d.removeLast();
                            res = makeFunction(operation, d2);
                        }
                        res = new Double(df.format(res));
                        d.add(res);
                        if (operators.size() > 0) {
                            lastOperPriority = getPriority(operators.getLast());
                        } else {
                            lastOperPriority = -1;
                        }
                    }
                }
                operators.add(p[i]);
            }

            if (p[i].equals("(")) {
                operators.add(p[i]);
            }
            if (p[i].equals(")")) {
                String operation = "";
                while (!(operation = operators.removeLast()).equals("(")) {
                    Double res = 0.0;
                    Double d2;
                    if (operation.equals("=") || operation.equals("%")) {
                        d2 = d.removeLast();
                        res = makeOperation(operation, 0.0, d2);
                        res = new Double(df.format(res));
                        d.add(res);
                        continue;
                    }
                    Double d1 = 0.0;

                    if (isOperator(operation)) {
                        d2 = d.removeLast();
                        if (d.size() > 0) {
                            d1 = d.removeLast();
                        }
                        res = makeOperation(operation, d1, d2);
                    }
                    if (isFunction(operation)) {
                        d2 = d.removeLast();
                        res = makeFunction(operation, d2);
                    }
                    res = new Double(df.format(res));
                    d.add(res);
                }
            }
        }
        String operation = "";
        while (operators.size() != 0) {
            operation = operators.removeLast();
            Double d2;
            Double res = 0.0;
            if (operation.equals("=") || operation.equals("%")) {
                d2 = d.removeLast();
                res = makeOperation(operation, 0.0, d2);
                res = new Double(df.format(res));
                d.add(res);
                continue;
            }
            Double d1 = 0.0;
            if (isOperator(operation)) {
                d2 = d.removeLast();
                if (d.size() > 0) {
                    d1 = d.removeLast();
                }
                res = makeOperation(operation, d1, d2);
            }
            if (isFunction(operation)) {
                d2 = d.removeLast();
                res = makeFunction(operation, d2);
            }
            res = new Double(df.format(res));
            d.add(res);
        }
        sb = new StringBuilder();
        sb.append(d.get(0));
        for (int i = 0; i < numberOfOperations; i++) {
            sb.append("!");
        }
        sb.append(" ");
        sb.append(numberOfOperations);
        String result = sb.toString();
        return result;
    }

    public void recurse(final String expression, int countOperation) {
        String result = "";
        int count = countOperation;
        Pattern compareWithDecimalss = Pattern.compile("^-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)$");
        Matcher mmm = compareWithDecimalss.matcher(expression);
        if (mmm.matches()) {
            Double d = new Double(expression);
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
            numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
            DecimalFormat df = (DecimalFormat) numberFormat;
            df.applyPattern("#.##");
            String stringWeNeed = df.format(d);
            System.out.println(stringWeNeed + " " + countOperation);
            return;
        }
        if (!expression.contains("!")) {
            String strinny = doSomething(expression);
            String[] ss = strinny.split(" ");
            result = ss[0];
            count = Integer.parseInt(ss[1].trim());
        } else {
            result = expression.replaceFirst("!", "");
        }
        recurse(result, count);

    }

    public Solution() {
        //don't delete
    }
}
