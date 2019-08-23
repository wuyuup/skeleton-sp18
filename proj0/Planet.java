import java.lang.Math;

public class Planet{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b){
        return Math.sqrt( (this.xxPos-b.xxPos)*(this.xxPos-b.xxPos) 
            + (this.yyPos-b.yyPos)*(this.yyPos-b.yyPos)  );
    }

    public double calcForceExertedBy(Planet b){
        double constG = 6.67e-11;
        double distanceBetween = this.calcDistance(b);
        return constG * this.mass * b.mass / distanceBetween / distanceBetween;
    }

    public double calcForceExertedByX(Planet b){
        double totalForce = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double rr = this.calcDistance(b);
        return totalForce * dx / rr;
    }

    public double calcForceExertedByY(Planet b){
        double totalForce = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double rr = this.calcDistance(b);
        return totalForce * dy / rr;
    }

    public double calcNetForceExertedByX(Planet[] bodies){
        int numBodies = bodies.length;
        double totalNetForce = 0.0;
        for (int i = 0; i < numBodies; ++i){
            if (this.equals(bodies[i])){
                continue;
            }
            totalNetForce = totalNetForce + this.calcForceExertedByX(bodies[i]);
        }
        return totalNetForce;
    }

    public double calcNetForceExertedByY(Planet[] bodies){
        int numBodies = bodies.length;
        double totalNetForce = 0.0;
        for (int i = 0; i < numBodies; ++i){
            if (this.equals(bodies[i])){
                continue;
            }
            totalNetForce = totalNetForce + this.calcForceExertedByY(bodies[i]);
        }
        return totalNetForce;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass; // accelaration on x
        double ay = fy / this.mass; // accelaration on y

        // update velocity
        this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;

        // update position
        this.xxPos = this.xxPos + this.xxVel*dt;
        this.yyPos = this.yyPos + this.yyVel*dt;

    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }



}