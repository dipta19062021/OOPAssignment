class Stack {
    int arri[];
    char arrc[];
    String arrs[];
    int top;
    String type;

    Stack(int size, String type) {
        this.type = type;
        if (type.equalsIgnoreCase("int")) {
            arri = new int[size];
            top = -1;
        } else if (type.equalsIgnoreCase("char")) {
            arrc = new char[size];
            top = -1;
        } else if (type.equalsIgnoreCase("string")) {
            arrs = new String[size];
            top = -1;
        } else {
            System.out.println("Invalid type");
        }
    }

    // Stack(char size) {
    // arrc = new char[size - '0'];
    // top = -1;
    // }

    // Stack(String size) {
    // arrs = new String[Integer.parseInt(size)];
    // top = -1;
    // }

    void push(int x) {
        if (top == arri.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arri[++top] = x;
        System.out.println("Pushed " + x);
    }

    void push(char x) {
        if (top == arrc.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arrc[++top] = x;
        System.out.println("Pushed " + x);
    }

    void push(String x) {
        if (top == arrs.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arrs[++top] = x;
        System.out.println("Pushed " + x);
    }

    String pop() {
        if (type.equalsIgnoreCase("int")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return Integer.toString(arri[top--]);
        } else if (type.equalsIgnoreCase("char")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return Character.toString(arrc[top--]);
        } else if (type.equalsIgnoreCase("string")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return arrs[top--];
        } else {
            System.out.println("Invalid type");
            return " ";
        }
    }

    // int popi() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return -1;
    // }
    // return arri[top--];
    // }

    // char popc() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return ' ';
    // }
    // return arrc[top--];
    // }

    // String pops() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return " ";
    // }
    // return arrs[top--];
    // }

    String peek() {
        if (type.equalsIgnoreCase("int")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return Integer.toString(arri[top]);
        } else if (type.equalsIgnoreCase("char")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return Character.toString(arrc[top]);
        } else if (type.equalsIgnoreCase("string")) {
            if (top == -1) {
                System.out.println("Stack underflow");
                return " ";
            }
            return arrs[top];
        } else {
            System.out.println("Invalid type");
            return " ";
        }
    }

    // int peeki() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return -1;
    // }
    // return arri[top];
    // }

    // char peekc() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return ' ';
    // }
    // return arrc[top];
    // }

    // String peeks() {
    // if (top == -1) {
    // System.out.println("Stack underflow");
    // return " ";
    // }
    // return arrs[top];
    // }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull(String type) {
        if (type.equalsIgnoreCase("int")) {
            return top == arri.length - 1;
        } else if (type.equalsIgnoreCase("char")) {
            return top == arrc.length - 1;
        } else if (type.equalsIgnoreCase("string")) {
            return top == arrs.length - 1;
        } else {
            System.out.println("Invalid type");
            return false;
        }
    }

    void display(String type) {
        if (type.equalsIgnoreCase("int")) {
            for (int i = 0; i <= top; i++) {
                System.out.println(arri[i] + " ");
            }
            System.out.println();
        } else if (type.equalsIgnoreCase("char")) {
            for (int i = 0; i <= top; i++) {
                System.out.println(arrc[i] + " ");
            }
            System.out.println();
        } else if (type.equalsIgnoreCase("string")) {
            for (int i = 0; i <= top; i++) {
                System.out.println(arrs[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Invalid type");
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack s1 = new Stack(5, "int");
        Stack s2 = new Stack(5, "char");
        Stack s3 = new Stack(5, "string");

        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println("Pop value: " + s1.pop());
        System.out.println("Peek value: " + s1.peek());
        s1.display("int");

        s2.push('a');
        s2.push('b');
        s2.push('c');
        System.out.println("Pop value: " + s2.pop());
        System.out.println("Peek value: " + s2.peek());
        s2.display("char");

        s3.push("abc");
        s3.push("def");
        s3.push("ghi");
        System.out.println("Pop value: " + s3.pop());
        System.out.println("Peek Value: " + s3.peek());
        s3.display("string");
    }
}