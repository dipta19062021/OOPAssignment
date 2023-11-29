import java.util.Random;

class Matrix {
    private int rows;
    private int columns;
    private int[][] data;

    // Constructor to create a matrix with random values
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
        populateMatrixRandomly();
    }

    // Accessor methods
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getElement(int row, int column) {
        return data[row][column];
    }

    // Mutator methods
    public void setElement(int row, int column, int value) {
        data[row][column] = value;
    }

    // Method to populate the matrix with random values
    private void populateMatrixRandomly() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextInt(10); // Adjust the bound as needed
            }
        }
    }

    // Method to multiply two matrices
    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication");
        }

        Matrix result = new Matrix(this.rows, other.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    // Method to add two matrices
    public Matrix add(Matrix other) {

        Matrix result = new Matrix(this.rows, this.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(i, j, this.data[i][j] + other.data[i][j]);
            }
        }

        return result;
    }

    // Method to transpose the matrix
    public Matrix transpose() {
        Matrix result = new Matrix(this.columns, this.rows);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.setElement(j, i, this.data[i][j]);
            }
        }

        return result;
    }
}

public class MatDemo {
    public static void main(String[] args) {
        // Test the Matrix class

        // Create two matrices with random values
        Matrix matrix1 = new Matrix(3, 3);
        Matrix matrix2 = new Matrix(3, 3);

        // Display the matrices
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        // Test matrix multiplication
        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Matrix Multiplication (Matrix 1 * Matrix 2):");
        displayMatrix(product);

        // Test matrix addition
        Matrix sum = matrix1.add(matrix2);
        System.out.println("Matrix Addition (Matrix 1 + Matrix 2):");
        displayMatrix(sum);

        // Test matrix transpose
        Matrix transposeMatrix1 = matrix1.transpose();
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix1);
    }

    // Helper method to display a matrix
    private static void displayMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(matrix.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
