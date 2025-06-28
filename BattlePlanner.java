import java.util.*;

public class BattlePlanner {



        static List<String> winningArrangementOrder = null;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your 5 platoons:");
            String[] ourPlatoons = scanner.nextLine().split(";");

            System.out.println("Enter opponent's 5 platoons:");
            String[] enemyPlatoons = scanner.nextLine().split(";");

            if (ourPlatoons.length != 5 || enemyPlatoons.length != 5) {
                System.out.println("Error: You must enter exactly 5 platoons for each side.");
                return;
            }

            List<String> ourList = new ArrayList<>(Arrays.asList(ourPlatoons));
            List<String> enemyList = Arrays.asList(enemyPlatoons);

            permuteAndFindWinningArrangementOrder(ourList, 0, enemyList);

            if (winningArrangementOrder != null) {
                System.out.println(String.join(";", winningArrangementOrder));

                int winCount = 0;
                List<String> battleOutcomes = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    String our = winningArrangementOrder.get(i);
                    String their = enemyList.get(i);
                    int result = battleResult(our, their);
                    String outcome = switch (result) {
                        case 1 -> {
                            winCount++;
                            yield "Win";
                        }
                        case 0 ->  "Draw";
                        case -1 ->  "Loss";
                        default -> "Unknown";
                    };
                    battleOutcomes.add("Battle " + (i + 1) + ": " + our + " vs " + their + " => " + outcome);
                }

                System.out.println("\nBattle Results:");
                for (String result : battleOutcomes) {
                    System.out.println(result);
                }

                System.out.println("\nTotal Battles Won: " + winCount + "/5");
            } else {
                System.out.println("There is no chance of winning");
            }
        }

        private static void permuteAndFindWinningArrangementOrder(List<String> ourList, int l, List<String> opponentList) {
            if (l == ourList.size()) {
                int noOfWins = 0;
                for (int i = 0; i < 5; i++) {
                    if (battleResult(ourList.get(i), opponentList.get(i)) > 0) {
                        noOfWins++;
                    }
                }
                if (noOfWins >= 3 && winningArrangementOrder == null) {
                    winningArrangementOrder = new ArrayList<>(ourList);
                }
                return;
            }

            for (int i = l; i < ourList.size(); i++) {
                Collections.swap(ourList, i, l);
                permuteAndFindWinningArrangementOrder(ourList, l + 1, opponentList);
                Collections.swap(ourList, i, l);
            }
        }

        private static int battleResult(String ourPlatoon, String enemyPlatoon) {
            String[] ourParts = ourPlatoon.split("#");
            String[] enemyParts = enemyPlatoon.split("#");

            String ourClass = ourParts[0];
            int ourCount = Integer.parseInt(ourParts[1]);

            String theirClass = enemyParts[0];
            int theirCount = Integer.parseInt(enemyParts[1]);

            int ourEffective = checkAdvantage(ourClass, theirClass) ? ourCount * 2 : ourCount;
            int theirEffective = checkAdvantage(theirClass, ourClass) ? theirCount * 2 : theirCount;

            return Integer.compare(ourEffective, theirEffective);
        }

        private static boolean checkAdvantage(String attacker, String defender) {
            return switch (attacker) {
                case "Militia" -> defender.equals("Spearmen") || defender.equals("LightCavalry");
                case "Spearmen" -> defender.equals("LightCavalry") || defender.equals("HeavyCavalry");
                case "LightCavalry" -> defender.equals("FootArcher") || defender.equals("CavalryArcher");
                case "HeavyCavalry" -> defender.equals("Militia") || defender.equals("FootArcher") || defender.equals("LightCavalry");
                case "CavalryArcher" -> defender.equals("Spearmen") || defender.equals("HeavyCavalry");
                case "FootArcher" -> defender.equals("Militia") || defender.equals("CavalryArcher");
                default -> false;
            };
        }



}