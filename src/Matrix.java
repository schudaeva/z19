//19. Создать класс Matrix для работы с двумерными матрицами. Создать методы для  генерации нулевой матрицы,
// а также для генерации матрицы со случайными величинами – применить Math.random(). Реализовать метод сложения матриц.
public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public static Matrix zeros(int rows, int cols) {
        return new Matrix(rows, cols);
    }

    public static Matrix random(int rows, int cols) {
        Matrix matrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.data[i][j] = Math.random();
            }
        }
        return matrix;
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix a = Matrix.random(3, 3);
        Matrix b = Matrix.zeros(3, 3);
        Matrix c = a.add(b);

        System.out.println("Matrix a:");
        a.print();
        System.out.println("Matrix b:");
        b.print();
        System.out.println("Matrix c:");
        c.print();


    }
}