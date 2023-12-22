import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;


class Parser {
    public static void parse(String path) {
        File file = new File(path);
        try {
            int taskNumber = 1;
            FileWriter writer = new FileWriter("src/result.txt");
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String trim = line.substring(line.indexOf(":") + 1).trim();
                if (line.startsWith("Ðåøèòå óðàâíåíèå:")) {
                    String equation = trim;
                    writer.write('\n');
                    writer.write("===Task " + taskNumber + "===\n");
                    writer.write("Ðåøèòå óðàâíåíèå: " + equation + "\n");
                    try {
                        double res = Calculate.calculates(equation);
                        writer.write(Calculate.findVariable(equation) + " = " + formatDouble(res) + "\n");
                    } catch (Exception e) {
                        writer.write("Íåâîçìîæíî âû÷èñëèòü ðåøåíèå óðàâíåíèÿ\n");
                    }
                    taskNumber++;
                }
                else if (line.startsWith("Íàéäèòå çíà÷åíèå âûðàæåíèÿ:")) {
                    String expression = trim;
                    writer.write('\n');
                    writer.write("===Task " + taskNumber + "===" + "\n");
                    writer.write("Íàéäèòå çíà÷åíèå âûðàæåíèÿ: " + expression + "\n");
                    try {
                        List<Symbol> Symbols = SymbolBuffer.symAnalyze(expression);
                        SymbolBuffer SymbolBuffer = new SymbolBuffer(Symbols);
                        double result = SymbolBuffer.expr(SymbolBuffer);
                        if (Double.isInfinite(result))
                            writer.write("Îøèáêà: äåëåíèå íà íîëü\n");
                        else {
                            writer.write(expression + " = " + formatDouble(result) + "\n");
                        }
                    } catch (Exception e) {
                        writer.write("Íåâîçìîæíî âû÷èñëèòü çíà÷åíèå âûðàæåíèÿ\n");
                    }
                    taskNumber++;
                } else if(line.startsWith("Íàéäèòå ðåøåíèå êâàäðàòíîãî óðàâíåíèÿ:")){
                    String expression = trim;
                    writer.write('\n');
                    writer.write("===Task " + taskNumber + "===" + "\n");
                    writer.write("Íàéäèòå ðåøåíèå êâàäðàòíîãî óðàâíåíèÿ: " + expression + "\n");
                    try{
                        String[] expressionWithoutSpace = expression.split(" ");
                        List ratio = new ArrayList<>();
                        for (int i = 0; i < expressionWithoutSpace.length;i++) {
                            if (expressionWithoutSpace[i].matches("[a-zA-Zà-ÿÀ-ß]")) {
                                if (i == 0) ratio.add(1.0);
                                else{
                                    double k = parseDouble(expressionWithoutSpace[i-2]);
                                    try{
                                        if (expressionWithoutSpace[i-3].matches("-")) {
                                            k *= -1;
                                        }
                                    } catch (IndexOutOfBoundsException e) {}
                                    ratio.add(k);
                                }
                            }
                            if (expressionWithoutSpace[i].matches( "=")){
                                double k = parseDouble(expressionWithoutSpace[i-1]);
                                if (expressionWithoutSpace[i-2].matches("-")) {
                                    k *= -1;
                                }
                                ratio.add(k);
                            }
                        }
                        List<Double> roots = getDoubles(ratio);
                        if (roots.isEmpty())
                            writer.write("Êâàäðàòíîå óðàâíåíèå íå èìååò äåéñòâèòåëüíûõ êîðíåé! \n");
                        else if (roots.size() == 1)
                            writer.write("x = " + formatDouble(roots.get(0)) + "\n");
                        else
                            writer.write("x1 = " + formatDouble(roots.get(0)) + "; x2 = " + formatDouble(roots.get(1)) + "\n");
                    }catch (Exception e){
                        writer.write("Íåâîçìîæíî âû÷èñëèòü çíà÷åíèå âûðàæåíèÿ\n");
                    }
                    taskNumber++;
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Îøèáêà: Ôàéë " + path + " íå íàéäåí");
        } catch (IOException e) {
            System.out.println("Îøèáêà ïðè çàïèñè â ôàéë");
        }
    }

    private static List<Double> getDoubles(List ratio) {
        QuadEqSolver quadraticSolver = (a, b, c) -> {
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                return Arrays.asList();
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                return Arrays.asList(root);
            } else {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return Arrays.asList(root1, root2);
            }
        };
        double a = (double) ratio.get(0);
        double b = (double) ratio.get(1);
        double c = (double) ratio.get(2);
        List<Double> roots = quadraticSolver.solveQuadraticEquation(a, b, c);
        return roots;
    }

    private static String formatDouble(double number) {
        if (number % 1 == 0) {
            return String.valueOf(number);
        } else {
            return String.format("%.3f", number);
        }
    }

}
