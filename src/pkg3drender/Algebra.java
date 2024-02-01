package pkg3drender;

public class Algebra {

    public double[][] matmul(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        double[][] c = null;

        if (colsA == rowsB) {
            c = new double[rowsA][colsB];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsB; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }

        return c;
    }

    public Vertex transform(Vertex in, double[][] matrix) {
        return new Vertex(in.x * matrix[0][0] + in.y * matrix[1][0] + in.z * matrix[2][0],
                in.x * matrix[0][1] + in.y * matrix[1][1] + in.z * matrix[2][1],
                in.x * matrix[0][2] + in.y * matrix[1][2] + in.z * matrix[2][2]);
    }
}
