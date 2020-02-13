package P5;

public class Sparsearray {
    public static void main(String[] args) {
        //创建一个原始数组11*11
        //1表示黑，2表示白，0表示无棋子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //输出原始二维数组
        System.out.println("=====原始数组======");
        for (int[] row:chessArr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println(" ");
        }

        //1、将原始二维数组转为稀疏数组
        //先遍历，得到非0数据的个数
        int sum = 0;
        for (int i=0;i<chessArr.length;i++){
            for (int j =0;j<chessArr[i].length;j++){
                if (chessArr[i][j] != 0){
                    sum += 1;
                }
            }
        }
        //System.out.println(sum);

        //2、创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非零数组存放到稀疏数组
        int count = 1;//计数器，表示稀疏数组的行数
        for (int i=0;i<chessArr.length;i++){
            for (int j =0;j<chessArr[i].length;j++){
                if (chessArr[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count += 1;
                }
            }
        }

        //遍历稀疏数组，打印
        System.out.println("=====稀疏数组======");
        for (int[] arr:sparseArr
             ) {
            for (int i:arr
                 ) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        //3、将稀疏数组转为原始数组
        int[][] transformedArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1;i<sparseArr.length;i++){
            //transformedArr就三列，所以不要再循环了
            //我一开始以为sum是它的列数，其实是它的行数
            transformedArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //遍历恢复后的数组
        System.out.println("======恢复后的稀疏数组=====");
        for (int[] row:transformedArr
             ) {
            for (int i:row
                 ) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
    }
}

