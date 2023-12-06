package Q1;

public class Rectangle {
        // 2 attributes "width" and "height" with appropriate getter methods
        // A constructor that requires values for width and height of the rectangle
        private int height;
        private int width;

        public Rectangle(int width, int height) {
            if (width < 0) {
                System.out.println("Error! Setting this value to 1.");
                this.width = 1;
            } else {
                this.width = width;
            }

            if (height < 0) {
                System.out.println("Error! Setting this value to 1.");
                this.height = 1;
            } else {
                this.height = height;
            }
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void visualize() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print("*"); 
                    // A visualize method to display the rectangle using "*" symbol 
                }
                System.out.println();
            }
        }
    }

