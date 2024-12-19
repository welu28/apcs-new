package FRQa;

import java.util.*;

public class Q3 {
    // Part A
    private Player[] slots;
    private List<String> waitingList;

    public Q3(int slotCount) {
        slots = new Player[slotCount];
        waitingList = new ArrayList<>();
    }

    public Player requestSlot(String playerName) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                Player newPlayer = new Player(playerName, i);
                slots[i] = newPlayer;
                return newPlayer;
            }
        }
        waitingList.add(playerName);
        return null;
    }

    // Part B
    public Player cancelAndReassignSlot(Player p) {
        int number = p.getnumber();
        slots[number] = null;

        if (!waitingList.isEmpty()) {
            String nextPlayerName = waitingList.remove(0);
            Player newPlayer = new Player(nextPlayerName, number);
            slots[number] = newPlayer;
            return newPlayer;
        }
        return null;
    }
}

class Player {
    private String name;
    private int number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getnumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

