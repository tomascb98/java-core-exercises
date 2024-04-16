package com.epam.rd.autotasks;


class Spiral {
    static int[][] spiral(int rows, int columns) {
        int [][] matrix = new int[rows][columns];
        String direction = "right";

        int horizontal=columns;
        int vertical=rows;

        int posX = 0;
        int posY = 0;

        int num = 1;

        while(vertical != 0 && horizontal != 0){
            switch (direction){
                case "right":
                    vertical--;
                    for (int j = posX, c=0 ; c<horizontal;j++,c++){
                        matrix[posY][j] = num;
                        num++;
                        posX = j;
                    }
                    posY++;
                    direction = "down";
                    break;
                case "down":
                    horizontal--;
                    for (int i = posY, c=0 ; c< vertical ; i++,c++){
                        matrix[i][posX] = num;
                        num++;
                        posY = i;
                    }
                    posX--;
                    direction = "left";

                    break;
                case "left":
                    vertical--;
                    for (int j = posX, c = 0 ; c < horizontal ; j--, c++){
                        matrix[posY][j] = num;
                        num++;
                        posX = j;
                    }
                    posY--;
                    direction = "up";

                    break;
                case "up":
                    horizontal--;
                    for(int i = posY, c=0 ; c < vertical; i--, c++){
                        matrix[i][posX] = num;
                        num++;
                        posY = i;
                    }
                    posX++;
                    direction="right";

                    break;

            }
        }


        return matrix;
    }
}
