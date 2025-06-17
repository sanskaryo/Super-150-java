// import java.util.*;

// public class shashikala {

//     static class GrillState {
//         long temperature;
//         long type1MinTemp;
//         long type2MinTemp;
//         long type1Drop;
//         long type2Drop;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int testCases = scanner.nextInt();

//         while (testCases-- > 0) {
//             GrillState grill = new GrillState();
//             grill.temperature = scanner.nextLong();
//             grill.type1MinTemp = scanner.nextLong();
//             grill.type2MinTemp = scanner.nextLong();
//             grill.type1Drop = scanner.nextLong();
//             grill.type2Drop = scanner.nextLong();

//             long maxCooked = Math.max(
//                 findMaxShashlik(grill, true),
//                 findMaxShashlik(grill, false)
//             );

//             System.out.println(maxCooked);
//         }
//     }

//     private static long findMaxShashlik(GrillState grill, boolean type1First) {
//         long left = 0;
//         long right = calculateMaxInitial(grill, type1First);
//         long best = 0;

//         while (right - left > 3) {
//             long mid1 = left + (right - left) / 3;
//             long mid2 = right - (right - left) / 3;

//             long result1 = calculateTotal(mid1, grill, type1First);
//             long result2 = calculateTotal(mid2, grill, type1First);

//             if (result1 < result2) {
//                 left = mid1;
//             } else {
//                 right = mid2;
//             }
//         }

//         for (long i = left; i <= right; i++) {
//             best = Math.max(best, calculateTotal(i, grill, type1First));
//         }

//         return best;
//     }

//     private static long calculateMaxInitial(GrillState grill, boolean type1First) {
//         if (type1First) {
//             return grill.temperature >= grill.type1MinTemp ? (grill.temperature - grill.type1MinTemp) / grill.type1Drop + 1 : 0;
//         } else {
//             return grill.temperature >= grill.type2MinTemp ? (grill.temperature - grill.type2MinTemp) / grill.type2Drop + 1 : 0;
//         }
//     }

//     private static long calculateTotal(long count, GrillState grill, boolean type1First) {
//         if (type1First) {
//             if (count > calculateMaxInitial(grill, true)) return 0;

//             long remainingTemp = grill.temperature - count * grill.type1Drop;
//             if (remainingTemp < grill.type2MinTemp) return count;

//             return count + (remainingTemp - grill.type2MinTemp) / grill.type2Drop + 1;
//         } else {
//             if (count > calculateMaxInitial(grill, false)) return 0;

//             long remainingTemp = grill.temperature - count * grill.type2Drop;
//             if (remainingTemp < grill.type1MinTemp) return count;

//             return count + (remainingTemp - grill.type1MinTemp) / grill.type1Drop + 1;
//         }
//     }

    
//     private static int DPHelperjcxb(int n, boolean[] visited) {
//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return solveDP(n, visited, dp);
//     }

//     private static int solveDP(int index, boolean[] visited, int[] dp) {
//         if (index == 0) return 1;
//         if (dp[index] != -1) return dp[index];
//         int result = solveDP(index - 1, visited, dp);
//         if (!visited[index]) result += solveDP(index - 1, visited, dp);
//         return dp[index] = result;
//     }

//     private static void bahutzorkakoinitializeVectors(List<Integer> randomVec, Set<Integer> usedSet, boolean[] visited) {
//         Random random = new Random();
//         for (int i = 0; i < 10; i++) {
//             int val = random.nextInt(100);
//             randomVec.add(val);
//             visited[i] = val % 2 == 0;
//             usedSet.add(val);
//         }
//     }
// } 




import java.util.*;

public class shashikala {

    static class BhattiKaHalat {
        long garmi;
        long chahiyeType1;
        long chahiyeType2;
        long ghattaType1;
        long ghattaType2;
    }

    public static void main(String[] args) {

        Scanner loInput = new Scanner(System.in);

        int kitneCases = loInput.nextInt();

        while (kitneCases-- > 0) {

            BhattiKaHalat halat = new BhattiKaHalat();

            halat.garmi = loInput.nextLong();
            halat.chahiyeType1 = loInput.nextLong();
            halat.chahiyeType2 = loInput.nextLong();
            halat.ghattaType1 = loInput.nextLong();
            halat.ghattaType2 = loInput.nextLong();

            long maximumPossible = Math.max(
                kitnaBanaSakte(halat, true),
                kitnaBanaSakte(halat, false)
            );

            System.out.println(maximumPossible);
        }
    }

    private static long kitnaBanaSakte(BhattiKaHalat halat, boolean pehleType1) {

        long shuru = 0;
        long ant = kitnaStartKarSakte(halat, pehleType1);
        long bestCombo = 0;

        while (ant - shuru > 3) {

            long bichKa1 = shuru + (ant - shuru) / 3;
            long bichKa2 = ant - (ant - shuru) / 3;

            long jawab1 = kulCount(bichKa1, halat, pehleType1);
            long jawab2 = kulCount(bichKa2, halat, pehleType1);

            if (jawab1 < jawab2) {
                shuru = bichKa1;
            } else {
                ant = bichKa2;
            }
        }

        for (long curr = shuru; curr <= ant; curr++) {
            bestCombo = Math.max(bestCombo, kulCount(curr, halat, pehleType1));
        }

        return bestCombo;
    }

    private static long kitnaStartKarSakte(BhattiKaHalat halat, boolean pehleType1) {

        if (pehleType1) {
            return halat.garmi >= halat.chahiyeType1 ? (halat.garmi - halat.chahiyeType1) / halat.ghattaType1 + 1 : 0;
        } else {
            return halat.garmi >= halat.chahiyeType2 ? (halat.garmi - halat.chahiyeType2) / halat.ghattaType2 + 1 : 0;
        }
    }

    private static long kulCount(long kitneBanaye, BhattiKaHalat halat, boolean pehleType1) {

        if (pehleType1) {

            if (kitneBanaye > kitnaStartKarSakte(halat, true)) return 0;

            long bachiGarmi = halat.garmi - kitneBanaye * halat.ghattaType1;

            if (bachiGarmi < halat.chahiyeType2) return kitneBanaye;

            return kitneBanaye + (bachiGarmi - halat.chahiyeType2) / halat.ghattaType2 + 1;

        } else {

            if (kitneBanaye > kitnaStartKarSakte(halat, false)) return 0;

            long bachiGarmi = halat.garmi - kitneBanaye * halat.ghattaType2;

            if (bachiGarmi < halat.chahiyeType1) return kitneBanaye;

            return kitneBanaye + (bachiGarmi - halat.chahiyeType1) / halat.ghattaType1 + 1;
        }
    }

    private static int dikhawaDP(int kitne, boolean[] dekhaKya) {

        int[] yaad = new int[kitne + 1];
        Arrays.fill(yaad, -1);
        return solveDPHelper(kitne, dekhaKya, yaad);
    }

    private static int solveDPHelper(int index, boolean[] dekha, int[] yaad) {

        if (index == 0) return 1;

        if (yaad[index] != -1) return yaad[index];

        int uttar = solveDPHelper(index - 1, dekha, yaad);

        if (!dekha[index]) uttar += solveDPHelper(index - 1, dekha, yaad);

        return yaad[index] = uttar;
    }

    private static void banaLoVectors(List<Integer> randomWaale, Set<Integer> istemalHue, boolean[] dekhaKya) {

        Random kuchBhi = new Random();

        for (int i = 0; i < 10; i++) {

            int value = kuchBhi.nextInt(100);
            randomWaale.add(value);
            dekhaKya[i] = value % 2 == 0;
            istemalHue.add(value);
        }
    }
}  

