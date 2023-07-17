import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

public class CoinChange {
    public static void coinChange(BigDecimal coinChange) {

        TreeMap<BigDecimal, Integer> amountByDenomination = new TreeMap<>();
        amountByDenomination.put(BigDecimal.valueOf(500), 1);
        amountByDenomination.put(BigDecimal.valueOf(200), 3);
        amountByDenomination.put(BigDecimal.valueOf(100), 5);
        amountByDenomination.put(BigDecimal.valueOf(50), 10);
        amountByDenomination.put(BigDecimal.valueOf(20), 20);
        amountByDenomination.put(BigDecimal.valueOf(10), 200);
        amountByDenomination.put(BigDecimal.valueOf(5), 100);
        amountByDenomination.put(BigDecimal.valueOf(2), 100);
        amountByDenomination.put(BigDecimal.valueOf(1), 10000);

        TreeMap<BigDecimal, Integer> changeByDenomination = new TreeMap<>();
        changeByDenomination.put(BigDecimal.valueOf(500), 0);
        changeByDenomination.put(BigDecimal.valueOf(200), 0);
        changeByDenomination.put(BigDecimal.valueOf(100), 0);
        changeByDenomination.put(BigDecimal.valueOf(50), 0);
        changeByDenomination.put(BigDecimal.valueOf(20), 0);
        changeByDenomination.put(BigDecimal.valueOf(10), 0);
        changeByDenomination.put(BigDecimal.valueOf(5), 0);
        changeByDenomination.put(BigDecimal.valueOf(2), 0);
        changeByDenomination.put(BigDecimal.valueOf(1), 0);

        BigDecimal doPrzeliczenia = coinChange.multiply(BigDecimal.valueOf(100));
        for (Map.Entry<BigDecimal, Integer> entry : amountByDenomination.descendingMap().entrySet()) {
            BigDecimal denomination = entry.getKey();
            Integer amount = entry.getValue();
            BigDecimal calosci = doPrzeliczenia.divide(denomination,0,  RoundingMode.FLOOR); // 13/5 = 2
            if (doPrzeliczenia.compareTo(BigDecimal.valueOf(0)) == 1 && amount > 0) { // compareTo returns 1 when bigger, 0 when equal and -1 when less
                if (doPrzeliczenia.compareTo(denomination) >= 0) {
                    if (calosci.compareTo(BigDecimal.valueOf(amount)) == 1 ) {
                        doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(BigDecimal.valueOf(amount)));
                        changeByDenomination.replace(denomination, amount.intValue());
                        amountByDenomination.replace(denomination, amount - amount.intValue());
                    }
                    else {
                        doPrzeliczenia = doPrzeliczenia.subtract(denomination.multiply(calosci));
                        changeByDenomination.replace(denomination, calosci.intValue());
                        amountByDenomination.replace(denomination, amount - calosci.intValue());
                    }
                }
            }
        }
        System.out.println("Reszta do wydania: " + coinChange);
        changeByDenomination.descendingMap().forEach((denomination, amount) -> {
            System.out.println("Wydaj " + amount + " monet " + denomination.divide(BigDecimal.valueOf(100)) + " zl");
        });
    }
}