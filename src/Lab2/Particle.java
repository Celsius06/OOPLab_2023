package Lab2;
import java.awt.Color;
import java.awt.Graphics;

public class Particle {
    private int x;
    private int y;
    private Direction direction;
    private Color color; 
    private Box box; 

    public Particle(int x, int y, Direction direction, Color color, Box box) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.color = color;
        this.box = box; 
    }

    public void move() {
        switch (this.direction) {
            case NORTH:
                this.y--;
                break;
            case NORTHEAST:
                this.y--;
                this.x++;
                break;
            case EAST:
                this.x++;
                break;
            case SOUTHEAST:
                this.y++;
                this.x++;
                break;
            case SOUTH:
                this.y++;
                break;
            case SOUTHWEST:
                this.y++;
                this.x--;
                break;
            case WEST:
                this.x--;
                break;
            case NORTHWEST:
                this.y--;
                this.x--;
                break;
        }
        
        if (this.x < 0) {
            this.x = -this.x;     //Reverse x
        } 
        else if (this.x > this.box.getWidth()) { 
        
            this.x = this.box.getWidth() - (this.x - this.box.getWidth());
        }
  
        if (this.y < 0) {
            this.y = -this.y;   // Reverse y
        } 
        else if (this.y > this.box.getHeight()) { 
 
            this.y = this.box.getHeight() - (this.y - this.box.getHeight());
        }
  

        if (this.x == 15) { 
            if (this.direction.equals(Direction.WEST)) {
                this.direction = Direction.EAST;
            }
            else if (this.direction.equals(Direction.NORTHWEST)) {
                this.direction = Direction.NORTHEAST;
            }
            else if (this.direction.equals(Direction.SOUTHWEST)) {
                this.direction = Direction.SOUTHEAST;
            }
        }
        else if (this.x == this.box.getWidth() - 15) { 
            if (this.direction.equals(Direction.EAST)) {
                this.direction = Direction.WEST;
            }
            else if (this.direction.equals(Direction.NORTHEAST)) {
                this.direction = Direction.NORTHWEST;
            }
            else if (this.direction.equals(Direction.SOUTHEAST)) {
                this.direction = Direction.SOUTHWEST;
            }
        }
  
        if (this.y == 15) { 
            if (this.direction.equals(Direction.NORTH)) {
                this.direction = Direction.SOUTH;
            }
            else if (this.direction.equals(Direction.NORTHEAST)) {
                this.direction = Direction.SOUTHEAST;
            }
            else if (this.direction.equals(Direction.NORTHWEST)) {
                this.direction = Direction.SOUTHWEST;
            }
        }
        else if (this.y == this.box.getHeight() - 15) { 
            if (this.direction.equals(Direction.SOUTH)) {
                this.direction = Direction.NORTH;
            }
            else if (this.direction.equals(Direction.SOUTHEAST)) {
                this.direction = Direction.NORTHEAST;
            }
            else if (this.direction.equals(Direction.SOUTHWEST)) {
                this.direction = Direction.NORTHWEST;
            }
        }
    }

    public boolean collidesWith(Particle otherParticle) {
        return this.x == otherParticle.x && this.y == otherParticle.y;
    }

    public void draw(Graphics g) { 
        g.setColor(this.color); 
        g.fillOval(this.x - 5, this.y - 5, 30, 30); 
    }

    public static void add(Particle p) {
    }

    public static int size() {
        return 0;
    }
}
