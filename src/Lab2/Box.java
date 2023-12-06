package Lab2;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Box {
    private int Width;
    private int Height;
    private List<Particle> particles;
    private int currentSteps;
    public String getNumberOfParticles;

    // Constructor
    public Box(int Width, int Height) {
        this.Width = Width;
        this.Height = Height;
        this.particles = new ArrayList<>();
    }

    public void addParticle(Particle particle) {
        this.particles.add(particle);
    }

    public void moveParticles() {
        for (Particle particle : this.particles) {
            particle.move();
        }
    }

    public void checkCollisions() {
        for (int i = 0; i < this.particles.size(); i++) {
            for (int j = i + 1; j < this.particles.size(); j++) {
                if (this.particles.get(i).collidesWith(this.particles.get(j))) {
                    this.particles.add(new Particle(
                    (int) (Math.random() * this.Width - 10),
                    (int) (Math.random() * this.Height - 10),
                    Direction.values()[(int) ((Math.random() * 8))],
                    new Color((int) (Math.random() * 0xFFFFFF)),
                    this
                    ));
                        
                    continue;
                }
            }
        }
    }

    public int getNumberOfParticles() {
        return this.particles.size();
    }

    // Get box width
    public int getWidth() { 
        return this.Width;
    }

    // Get box height
    public int getHeight() { 
        return this.Height;
    }

    public void visualize(int n) {
        JFrame frame = new JFrame("Box of Particles"); 
        frame.setSize(this.Width + 20, this.Height + 40); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JPanel panel = new JPanel() { 
            @Override
            public void paintComponent(Graphics g) { 
                super.paintComponent(g); 
                g.setColor(Color.BLACK); 
                g.drawString("Number of Particles: " + getNumberOfParticles(), 20, 20);
                g.drawString("Steps: " + currentSteps, Width - 70, 20);
                g.drawRect(10, 10, Width, Height); 
                for (Particle particle : particles) { 
                    particle.draw(g); 
                }
            }
        };

        frame.add(panel); 
        frame.setVisible(true); 

        final int[] stepsRemaining = {n};

        Timer timer = new Timer (10, e-> {
            moveParticles();
            checkCollisions();
            panel.repaint();
            currentSteps = stepsRemaining[0];
            if (n<=0) {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();

        for (int i = 0; i < n; i++) {
            moveParticles();
            checkCollisions();
            panel.repaint();
        }
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

