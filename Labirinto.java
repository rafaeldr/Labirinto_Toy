package labirinto;

import java.util.Random;

public class Labirinto {
    
    public static void main(String[] args) {
        
        int linhas = 10;
        int colunas = 10;
        int[] qtdPassos = new int[1];
        qtdPassos[0] = 0;
        
        int[][] labirinto;
        labirinto = inicializaMatriz(linhas,colunas);
        
        if (!proximoPonto(0, 0, labirinto, linhas, colunas, false, true, qtdPassos))
        {
            imprimeMatriz(labirinto, linhas, colunas);
            System.out.println("SEM SAÍDA");
        } else
        {
            imprimeMatriz(labirinto, linhas, colunas);
        }
        
        System.out.println("Quantidade de Passos: "+qtdPassos[0]);
    }
    

    // Retorna se está no ponto final ou não
    // Retorno FALSE continua; TRUE PARA
    public static boolean proximoPonto(int x, int y, int[][] matriz, int qtdLinhas, int qtdColunas, boolean imprimePassos, boolean inicial, int[] passos)
    {
        passos[0]++;
        // Trata o caso da saída ser numa parede
        if (matriz[x][y] == 1)
        {
            //imprimeMatriz(matriz, qtdLinhas, qtdColunas);
            System.out.println("NÃO TEM COMO COMEÇAR");
            return true;
        }
        
        // Pisou
        matriz[x][y] = 8;
        
        if(imprimePassos){
            imprimeMatriz(matriz, qtdLinhas, qtdColunas);
        }
        
        // Terminou? ou Não tem como começar
        if(x == qtdLinhas-1 && y == qtdColunas-1)
        {
            System.out.println("TERMINOU!!!");
            return true;
        } else if (!inicial && x == 0 && y == 0)
        {
            System.out.println("SEM SAÍDA");
            return true;
        }

        // Direita
        if(y+1<=qtdLinhas-1 && matriz[x][y+1] != 1 && matriz[x][y+1] != 8)
        {
            if(proximoPonto(x, y+1, matriz, qtdLinhas, qtdColunas, imprimePassos, false, passos))
                return true;
        }
        // Baixo
        if(x+1<=qtdColunas-1 && matriz[x+1][y] != 1 && matriz[x+1][y] != 8)
        {
            if(proximoPonto(x+1, y, matriz, qtdLinhas, qtdColunas, imprimePassos, false, passos))
                return true;
        }
        // Esquerda
        if(y-1>=0 && matriz[x][y-1] != 1 && matriz[x][y-1] != 8)
        {
            if(proximoPonto(x, y-1, matriz, qtdLinhas, qtdColunas, imprimePassos, false, passos))
                return true;
        }
        // Cima
        if(x-1>=0 && matriz[x-1][y] != 1 && matriz[x-1][y] != 8)
        {
            if(proximoPonto(x-1, y, matriz, qtdLinhas, qtdColunas, imprimePassos, false, passos))
                return true;
        }
        return false;
    }
    
    public static int[][] inicializaMatriz(int numLinhas, int numColunas)
    {
        int um =0;
        int zero=0;
        int[][] matriz = new int[numLinhas][numColunas];
        // Preenche aleatóriamente
        for(int i = 0; i< numLinhas; i++)
        {
            for(int j = 0; j<numColunas;j++)
            {
                if(i == 0 && j == 0 || i == numLinhas-1 && j == numColunas-1)
                {
                    // Para evitar matrizes grandes perdidas
                    matriz[i][j] = 0;
                }
                int aleat = -1;
                //Preenche aleatóriamente
                Random r = new Random();
                
                // * devition + average
                while(aleat!=0 && aleat !=1)
                {
                    double val = r.nextGaussian() * 0.5 + 0.15;
                    aleat = (int) Math.round(val);
                }
                
                if (aleat==1)
                    um++;
                if (aleat==0)
                    zero++;
                
                matriz[i][j] = aleat;
                r.nextGaussian();
                //matriz[i][j] = 0;
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println();
        System.out.println("Zeros: "+zero);
        System.out.println("Uns: "+um);
        System.out.println();
        System.out.println();
        return matriz;
    }
    
    public static void imprimeMatriz(int[][] matriz, int numLinhas, int numColunas)
    {
        for(int i = 0; i< numLinhas; i++)
        {
            for(int j = 0; j<numColunas;j++)
            {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
}

