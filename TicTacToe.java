import java.util.*;
class Main {
    public static void main(String[] args) {
        int veticalX = 0;
        int horizontalX = 0;
        int diagonalX = 0;
        int nX = 0;

        int veticalO = 0;
        int horizontalO = 0;
        int diagonalO = 0;
        int nO = 0;

        int y = 0;
        int x = 0;
        Scanner tempSc;

        int z = 0;
        Scanner sc = new Scanner(System.in);
        char[] cells = new char[9];
        Arrays.fill(cells, ' ');
        System.out.println("---------");
        System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
        System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
        System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
        System.out.println("---------");

        while (true) {
            veticalX = 0;
            horizontalX = 0;
            diagonalX = 0;
            nX = 0;

            veticalO = 0;
            horizontalO = 0;
            diagonalO = 0;
            nO = 0;
            while (true) {
                tempSc = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");
                if (tempSc.hasNextInt()) {
                    y = tempSc.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (tempSc.hasNextInt()) {
                    x = tempSc.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (cells[((y * 3) - 3) + x - 1] != '_' && cells[((y * 3) - 3) + x - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                break;
            }
            if (z % 2 == 0) {   
                cells[((y * 3) - 3) + x - 1] = 'X';
                z++;
            } else {
                cells[((y * 3) - 3) + x - 1] = 'O';
                z++;
            }

            System.out.println("---------");
            System.out.println("| " + cells[0] + " " + cells[1] + " " + cells[2] + " |");
            System.out.println("| " + cells[3] + " " + cells[4] + " " + cells[5] + " |");
            System.out.println("| " + cells[6] + " " + cells[7] + " " + cells[8] + " |");
            System.out.println("---------");
            //X's
            for (int i = 0; i < 9; i = i + 3) {
                if (cells[i] == 'X' && cells[i + 1] == 'X' && cells[i + 2] == 'X') {
                    horizontalX++;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (cells[i] == 'X' && cells[i + 3] == 'X' && cells[i + 6] == 'X') {
                    veticalX++;
                }
            }
            for (int i = 0; i < 4; i = i + 2) {
                if (cells[i + 0] == 'X' && cells[4] == 'X' && cells[8 - i] == 'X') {
                    diagonalX++;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (cells[i] == 'X') {
                    nX++;
                }
            }
            //O's
            for (int i = 0; i < 9; i = i + 3) {
                if (cells[i] == 'O' && cells[i + 1] == 'O' && cells[i + 2] == 'O') {
                    horizontalO++;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (cells[i] == 'O' && cells[i + 3] == 'O' && cells[i + 6] == 'O') {
                    veticalO++;
                }
            }
            for (int i = 0; i < 4; i = i + 2) {
                if (cells[i + 0] == 'O' && cells[4] == 'O' && cells[8 - i] == 'O') {
                    diagonalO++;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (cells[i] == 'O') {
                    nO++;
                }
            }
        
            if (veticalO > 0 && veticalX > 0 || horizontalO > 0 && horizontalX > 0) {
                System.out.println("Impossible");
                break;
            } else if (nO > nX + 1 || nX > nO + 1) {
                System.out.println("Impossible");
                break;
            } else if ( diagonalX == 2|| diagonalO == 2) {
                System.out.println("Impossible");
                break;
            } else if (veticalX == 1 || horizontalX == 1 || diagonalX == 1) {
                System.out.println("X wins");
                break;
            }
            else if (veticalO == 1 || horizontalO == 1 || diagonalX == 1) {
                System.out.println("O wins");
                break;
            } else if (nO + nX == 9) {
                System.out.println("Draw");
                break;
            } /*else {
                System.out.println("Game not finished");
            }*/
        }
        sc.close();
    }
}
