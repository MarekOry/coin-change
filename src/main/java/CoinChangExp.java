//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class CoinChangeExperiments {
//    public static void coinChange(BigDecimal reszta) {
///*        TreeMap<BigDecimal, Integer> amountByDenomination = new TreeMap<>();
//        amountByDenomination.put(BigDecimal.valueOf(5), 1);
//        amountByDenomination.put(BigDecimal.valueOf(2), 3);
//        amountByDenomination.put(BigDecimal.valueOf(1), 5);
//        amountByDenomination.put(BigDecimal.valueOf(0.5), 10);
//        amountByDenomination.put(BigDecimal.valueOf(0.2), 20);
//        amountByDenomination.put(BigDecimal.valueOf(0.1), 200);
//        amountByDenomination.put(BigDecimal.valueOf(0.05), 100);
//        amountByDenomination.put(BigDecimal.valueOf(0.02), 100);
//        amountByDenomination.put(BigDecimal.valueOf(0.01), 10000);
//*/
//        TreeMap<BigDecimal, Integer> amountByDenomination = new TreeMap<>();
//        amountByDenomination.put(BigDecimal.valueOf(500), 1);
//        amountByDenomination.put(BigDecimal.valueOf(200), 3);
//        amountByDenomination.put(BigDecimal.valueOf(100), 5);
//        amountByDenomination.put(BigDecimal.valueOf(50), 10);
//        amountByDenomination.put(BigDecimal.valueOf(20), 20);
//        amountByDenomination.put(BigDecimal.valueOf(10), 200);
//        amountByDenomination.put(BigDecimal.valueOf(5), 100);
//        amountByDenomination.put(BigDecimal.valueOf(2), 100);
//        amountByDenomination.put(BigDecimal.valueOf(1), 10000);
//
//        TreeMap<BigDecimal, Integer> changeByDenomination = new TreeMap<>();
//        changeByDenomination.put(BigDecimal.valueOf(500), 0);
//        changeByDenomination.put(BigDecimal.valueOf(200), 0);
//        changeByDenomination.put(BigDecimal.valueOf(100), 0);
//        changeByDenomination.put(BigDecimal.valueOf(50), 0);
//        changeByDenomination.put(BigDecimal.valueOf(20), 0);
//        changeByDenomination.put(BigDecimal.valueOf(10), 0);
//        changeByDenomination.put(BigDecimal.valueOf(5), 0);
//        changeByDenomination.put(BigDecimal.valueOf(2), 0);
//        changeByDenomination.put(BigDecimal.valueOf(1), 0);
//
//        /*BigDecimal doPrzeliczenia = reszta;
//        amountByDenomination.descendingMap().forEach((nominal, amount) -> {
//            if(reszta.remainder(nominal) == BigDecimal.valueOf(0)) {
//                System.out.println("Wydaj" + reszta.divide(nominal) + "monet" + nominal + "zl");
//            } else {
//                BigDecimal calosci = reszta.divide(nominal, RoundingMode.FLOOR); // 13/5 = 2
//                doPrzeliczenia = doPrzeliczenia.subtract(calosci.multiply(nominal));
//            }
//        });*/
////logika: 1.reszta <= nominal 2. value > 0
///*        BigDecimal doPrzeliczenia = reszta;
//        for (Map.Entry<BigDecimal, Integer> entry : amountByDenomination.descendingMap().entrySet()) {
//            BigDecimal nominal = entry.getKey();
//            Integer amount = entry.getValue();
//            if (doPrzeliczenia.remainder(nominal) == BigDecimal.valueOf(0) && amount > 0) {
//                System.out.println("Wydaj " + doPrzeliczenia.divide(nominal) + " monet " + nominal + " zl");
//                amountByDenomination.replace(nominal, amount-1);
//            } else {
//                BigDecimal calosci = doPrzeliczenia.divide(nominal, RoundingMode.FLOOR); // 13/5 = 2
//                 if (calosci.compareTo(BigDecimal.valueOf(amount)) == 1) {
//                    doPrzeliczenia = doPrzeliczenia.subtract(nominal.multiply(BigDecimal.valueOf(amount)));
//                     amountByDenomination.replace(nominal, amount = 0);
//                 } else {
//                     doPrzeliczenia = doPrzeliczenia.subtract(calosci.multiply(nominal));
//                     amountByDenomination.replace(nominal, amount - calosci.intValue());
//                 }
//
////                System.out.println(amountByDenomination.descendingMap());
////                System.out.println(doPrzeliczenia);
//            }
//        }*/
//        /*BigDecimal doPrzeliczenia = reszta;
//        for (Map.Entry<BigDecimal, Integer> entry : amountByDenomination.descendingMap().entrySet()) {
//            BigDecimal denomination = entry.getKey();
//            Integer amount = entry.getValue();
//            BigDecimal calosci = doPrzeliczenia.divide(denomination, RoundingMode.FLOOR); // 13/5 = 2
//            if (amount > 0 && doPrzeliczenia.compareTo(denomination) <= 0) {
//                if (calosci.compareTo(BigDecimal.valueOf(amount)) == 1 ) {
//                    doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(BigDecimal.valueOf(amount)));
//                    System.out.println("Wydaj " + calosci + " monet " + denomination + " zl");
//                    amountByDenomination.replace(denomination, amount - calosci.intValue());
//                }
//                else {
//                    doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(calosci));
//                    System.out.println("Wydaj " + calosci + " monet " + denomination + " zl");
//                    amountByDenomination.replace(denomination, amount - calosci.intValue());
//                }
//            }*/
//        BigDecimal doPrzeliczenia = reszta.multiply(BigDecimal.valueOf(100));
//        for (Map.Entry<BigDecimal, Integer> entry : amountByDenomination.descendingMap().entrySet()) {
//            BigDecimal denomination = entry.getKey();
//            Integer amount = entry.getValue();
//            BigDecimal calosci = doPrzeliczenia.divide(denomination,0,  RoundingMode.FLOOR); // 13/5 = 2
//            if (doPrzeliczenia.compareTo(BigDecimal.valueOf(0)) == 1 && amount > 0) {
//                if (doPrzeliczenia.compareTo(denomination) >= 0) {
//                    if (calosci.compareTo(BigDecimal.valueOf(amount)) == 1 ) {
//                        doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(BigDecimal.valueOf(amount)));
//                        changeByDenomination.replace(denomination, amount.intValue());
//                        amountByDenomination.replace(denomination, amount - amount.intValue());
//                    }
//                    else {
//                        doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(calosci));
//                        changeByDenomination.replace(denomination, calosci.intValue());
//                        amountByDenomination.replace(denomination, amount - calosci.intValue());
//                    }
//                }
//            } //System.out.println(doPrzeliczenia);
////                System.out.println(amountByDenomination.descendingMap());
////                System.out.println(doPrzeliczenia);
////            System.out.println(calosci.intValue());
//
//        }
//        System.out.println("Reszta do wydania: " + reszta);
//        changeByDenomination.descendingMap().forEach((denomination, amount) -> {
//            System.out.println("Wydaj " + amount + " monet " + denomination.divide(BigDecimal.valueOf(100)) + " zl");
//        });
//        System.out.println(doPrzeliczenia);
//        System.out.println(amountByDenomination);
//    }
//}
