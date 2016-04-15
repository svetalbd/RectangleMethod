package com.goit.rectanglemethod;

import java.util.*;

/**
 * Created by Сергей on 12.04.2016.
 */
public class ConvertFunctionToRPN {
    private  String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    public static final Map<String, Integer> OPERATORS;
    static {
        OPERATORS = new HashMap<String, Integer>();
        OPERATORS.put("^", 1);
        OPERATORS.put("*", 2);
        OPERATORS.put("/", 2);
        OPERATORS.put("sin", 2);
        OPERATORS.put("cos", 2);
        OPERATORS.put("exp", 2);
        OPERATORS.put("tg", 2);
        OPERATORS.put("arctan", 2);
        OPERATORS.put("-", 3);
        OPERATORS.put("+", 3);
        OPERATORS.put("(", 4);
        OPERATORS.put(")", 4);
    }

    private static String preChange (String newFunction){
        newFunction = newFunction.replaceAll(" ", "");
        newFunction = newFunction.replaceAll(",", ".");
        return newFunction;
    }


    public static String conversionToRPN(String newFunction, Map<String, Integer> operations) {
        String leftBracket = "(";
        String rightBracket = ")";
        int index = 0;
        boolean endOperation = false;

        newFunction = preChange(newFunction);
        List<String> listOfConversationsToRPN = new ArrayList<String>();
        Stack<String> stackOfOperations = new Stack<String>();
        Set<String> allOperations = new HashSet<String>(operations.keySet());


        while (!endOperation) {
            int nextOperationIndex = newFunction.length();
            String nextOperation = "";
            for (String operation : allOperations) {
                int i = newFunction.indexOf(operation, index);
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation;
                    nextOperationIndex = i;
                }
            }
            if (nextOperationIndex == newFunction.length()) {
                endOperation = true;
            } else {
                if (index != nextOperationIndex) {
                    listOfConversationsToRPN.add(newFunction.substring(index, nextOperationIndex));
                }
                if (nextOperation.equals(leftBracket)) {
                    stackOfOperations.push(nextOperation);
                } else if (nextOperation.equals(rightBracket)) {
                    while (!stackOfOperations.peek().equals(leftBracket)) {
                        listOfConversationsToRPN.add(stackOfOperations.pop());
                        if (stackOfOperations.empty()) {
                            System.out.println("ERROR: Empty brackets.");
                            break;
                        }
                    }
                    stackOfOperations.pop();
                } else {
                    while (!stackOfOperations.empty() && !stackOfOperations.peek().equals(leftBracket) &&
                            (operations.get(nextOperation) >= operations.get(stackOfOperations.peek()))) {
                        listOfConversationsToRPN.add(stackOfOperations.pop());
                    }
                    stackOfOperations.push(nextOperation);
                }
                index = nextOperationIndex + nextOperation.length();
            }
        }

        if (index != newFunction.length()) {
            listOfConversationsToRPN.add(newFunction.substring(index));
        }
        while (!stackOfOperations.empty()) {
            listOfConversationsToRPN.add(stackOfOperations.pop());
        }
        StringBuffer rpn = new StringBuffer();
        if (!listOfConversationsToRPN.isEmpty()) {
            rpn.append(listOfConversationsToRPN.remove(0));
        }
        while (!listOfConversationsToRPN.isEmpty()) {
            rpn.append(" ").append(listOfConversationsToRPN.remove(0));
        }

        return rpn.toString();
    }


    public static Double calculateIntegral(String expression, Double x) {
        boolean validValue = true;
        String rpn = conversionToRPN(expression, OPERATORS);
        String[] delims = rpn.split(" ");
        Stack<Double> result = new Stack<Double>();

        for (int i = 0; i < delims.length; i++) {
            String e = delims[i];
            if (!OPERATORS.keySet().contains(e)) {
                if (e.equals("pi") || e.equals("Pi") || e.equals("PI")) {
                    result.push(Math.PI);
                } else if (e.equals("e") || e.equals("E")) {
                    result.push(Math.E);
                } else if (delims[i].equals("x") || delims[i].equals("y") || delims[i].equals("z")) {
                    result.push(x);
                } else {
                    try {
                        result.push(new Double(e));
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: an error in the recording of expression. ");
                        System.exit(-1);
                    }
                }
            } else {
                Double op2 = result.pop();
                Double op1 = result.empty() ? 0d : result.pop();
                switch (e) {
                    case "*":
                        result.push(op1 * op2);
                        break;
                    case "/":
                        if (op2.equals(0d)) {
                            System.out.println("ERROR: division by zero");
                            System.exit(-1);
                        } else {
                            result.push(op1 / op2);
                            break;
                        }
                    case "+":
                        result.push(op1 + op2);
                        break;
                    case "-":
                        result.push(op1 - op2);
                        break;
                    case "^":
                        result.push(Math.pow(op1, op2));
                        break;
                    case "sin":
                        if (op1 != 0) {
                            result.push(op1);
                        }
                        result.push(Math.sin(op2));
                        break;
                    case "cos":
                        if (op1 != 0) {
                            result.push(op1);
                        }
                        result.push(Math.cos(op2));
                        break;
                    case "tg":
                        if (op1 != 0) {
                            result.push(op1);
                        }
                        result.push(Math.tan(op2));
                        break;
                    case "arctan":
                        if (op1 != 0) {
                            result.push(op1);
                        }
                        result.push(Math.atan(op2));
                        break;
                    case "exp":
                        if (op1 != 0) {
                            result.push(op1);
                        }
                        result.push(Math.exp(op2));
                        break;
                    default:
                        System.out.println("ERROR: an error in the recording of expression. ");
                        System.exit(-1);
                }
            }
        }
        return (double) result.pop();
    }

}