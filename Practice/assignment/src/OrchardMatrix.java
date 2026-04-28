import java.util.ArrayList;
import java.util.List;

public class OrchardMatrix {

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; //row's
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; //column's

    public static void grid(){
        char[][] grid = {
                {'O', 'T', 'O', 'O'},
                {'O', 'T', 'O', 'T'},
                {'T', 'T', 'O', 'T'},
                {'O', 'T', 'O', 'T'}
        };

        List<Integer> list = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 'T'){
                    int size = dfs(grid, i, j);
                    list.add(size);
                }
            }
        }

        System.out.println(list);
    }//grid

    private static int dfs(char[][] grid, int i, int j) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 'O') return 0;

        grid[i][j] = 'O'; //marked as visited

        int count = 1;

        for(int k = 0; k < 8; k++){
            count += dfs(grid, i + dr[k], j + dc[k]);
        }

        return count;
    }//dfs


}//class
