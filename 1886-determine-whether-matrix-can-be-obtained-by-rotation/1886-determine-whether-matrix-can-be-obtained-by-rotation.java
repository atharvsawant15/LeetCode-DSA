class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            ninetyDegreeRotate(mat);
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
        }
        return false;
    }

    public static int[][] ninetyDegreeRotate(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] =  temp;
            }
        }

        for(int i=0;i<mat.length;i++){
            int st = 0;
            int end = mat.length-1;
            while(st<=end){
                int temp = mat[i][st];
                mat[i][st] = mat[i][end];
                mat[i][end] = temp;
                st++;
                end--;
            }
        }
        return mat;
    }
}