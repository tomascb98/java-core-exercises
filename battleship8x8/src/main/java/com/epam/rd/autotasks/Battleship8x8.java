package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int column = -1;
        int row = Integer.parseInt(String.valueOf(shot.charAt(1)));
        switch (shot.charAt(0)){
            case 'A' : column = 0; break;
            case 'B' : column = 1; break;
            case 'C' : column = 2; break;
            case 'D' : column = 3; break;
            case 'E' : column = 4; break;
            case 'F' : column = 5; break;
            case 'G' : column = 6; break;
            case 'H' : column = 7; break;
            default: break;
        }

        String[] boardOfShots = binaryToArray(shots);

        if(boardOfShots[row-1].charAt(column) == '1') return false;

        StringBuilder stringBuilder = new StringBuilder(boardOfShots[row-1]);
        stringBuilder.setCharAt(column, '1');
        boardOfShots[row-1] = String.valueOf(stringBuilder);

        StringBuilder shotsBuilder = new StringBuilder();
        for (String line: boardOfShots) {
            shotsBuilder.append(line);
        }
        shots = new BigInteger(shotsBuilder.toString(), 2).longValue();

        String[] boardOfShips = binaryToArray(ships);
        return boardOfShips[row - 1].charAt(column) == '1' && boardOfShots[row - 1].charAt(column) == '1';
    }

    public String state() {
        String boardShots;
        if(shots == 0L) boardShots = "0000000000000000000000000000000000000000000000000000000000000000";
        else boardShots = fixBinaryString(Long.toBinaryString(shots));

        String boardShips = fixBinaryString(Long.toBinaryString(ships));

        StringBuilder stateToReturn = new StringBuilder();
        int countForNewline = 0;
        for(int i=0 ; i<boardShips.length(); i++){
            if(boardShips.charAt(i) == '1' && boardShots.charAt(i) == '1') stateToReturn.append('☒');
            else if(boardShips.charAt(i) == '1' && boardShots.charAt(i) == '0') stateToReturn.append('☐');
            else if(boardShips.charAt(i) == '0' && boardShots.charAt(i) == '1') stateToReturn.append('×');
            else stateToReturn.append('.');
            countForNewline++;
            if(countForNewline == 8){
                countForNewline = 0;
                stateToReturn.append(System.lineSeparator());
            }
        }
        return String.valueOf(stateToReturn.substring(0, stateToReturn.length() - 1));
    }

    private String[] binaryToArray (Long toBinary){
        String state;
        if(toBinary == 0L) state = "0000000000000000000000000000000000000000000000000000000000000000";
        else state = fixBinaryString(Long.toBinaryString(toBinary));

        String[] board8x8 = new String[8];
        int indexToAdd = 0;
        for(int i=0 ; i<state.length() ; i+=8){
            int endIndex = i + 8;
            board8x8[indexToAdd] = state.substring(i,endIndex);
            indexToAdd++;
        }
        return board8x8;
    }

    private static String fixBinaryString(String binaryString) {
        int currentLength = binaryString.length();
        int targetLength = 64;

        if (currentLength < targetLength) {
            // Pad with leading zeros
            int numberOfZerosToPad = targetLength - currentLength;
            return "0".repeat(numberOfZerosToPad) +
                    binaryString;
        } else if (currentLength > targetLength) {
            // Truncate if it's longer than 64 bits
            return binaryString.substring(currentLength - targetLength);
        } else {
            // No modification needed
            return binaryString;
        }
    }
}
