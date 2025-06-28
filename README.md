# 🏰 Age of War - Platoon Battle Strategy Game

**Age of War** is a Java-based strategic simulation game where you command a medieval army and attempt to defeat your opponent in 5 simultaneous battles.

The outcome of each battle depends on the number of units and class-based advantages. Your goal is to rearrange your platoons in an optimal way to win at least 3 out of 5 battles.

---

## 🎯 Objective

- Rearrange your 5 platoons strategically.
- Match them against your opponent's fixed platoons.
- Win **at least 3 out of 5** battles to be victorious.

---

## ⚔️ Game Rules

- Each platoon has a soldier **class** and a number of units.
- Each class has strengths and weaknesses against others.
- If your class has an advantage over the opponent, each of your soldiers counts as **2**.
- If not, it's a **1-to-1** comparison.
- You win a battle if your effective strength > opponent’s.

---

## 👑 Unit Class Advantage Table

| Class           | Has Advantage Over                         |
|----------------|---------------------------------------------|
| Militia         | Spearmen, LightCavalry                     |
| Spearmen        | LightCavalry, HeavyCavalry                 |
| LightCavalry    | FootArcher, CavalryArcher                 |
| HeavyCavalry    | Militia, FootArcher, LightCavalry         |
| CavalryArcher   | Spearmen, HeavyCavalry                    |
| FootArcher      | Militia, CavalryArcher                    |

---

## 🧩 Sample Input Format

```
Your Platoons:
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120

Opponent Platoons:
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
```

---

## ✅ Sample Output

```
Militia#30;FootArcher#20;Spearmen#10;LightCavalry#1000;HeavyCavalry#120

Battle Results:
Battle 1: Militia#30 vs Militia#10 => Win
Battle 2: FootArcher#20 vs Spearmen#10 => Win
Battle 3: Spearmen#10 vs FootArcher#1000 => Loss
Battle 4: LightCavalry#1000 vs LightCavalry#120 => Win
Battle 5: HeavyCavalry#120 vs CavalryArcher#100 => Loss

Total Battles Won: 3/5
```

---

## 🚀 How to Run

```bash
javac PlatoonBattleGame.java
java PlatoonBattleGame
```

---

## 📁 Project Structure

```
├── PlatoonBattleGame.java
├── README.md
```

---

## 📜 License

This project is open source and free to use.

---

## 🙌 Contributions

Feel free to raise issues or pull requests if you'd like to contribute to the game logic, UI, or enhancements.
