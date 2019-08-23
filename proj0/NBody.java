public class NBody{
	public static double readRadius(String fileN){
		In in = new In(fileN);

		// read the number of bodies but not use it
		in.readInt();

		// return radius
		return in.readDouble();
	}

	public static Planet[] readBodies(String fileN){
		In in = new In(fileN);
		int numBodies = in.readInt();
		Planet[] bodies = new Planet[numBodies];

		// read the radius of the universe but not use it
		in.readDouble();
		// loop to store data in bodies
		for (int i = 0; i < numBodies; ++i){
			double currxxPos = in.readDouble();
			double curryyPos = in.readDouble();
			double currxxVel = in.readDouble();
			double curryyVel = in.readDouble();
			double currmass = in.readDouble();
			String currimgFileName = in.readString();
			bodies[i] = new Planet(currxxPos, curryyPos, currxxVel, 
				curryyVel, currmass, currimgFileName);
		}

		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double univRad = readRadius(filename);
		Planet[] bodies = readBodies(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-univRad, univRad);
		StdDraw.clear();

		int numBodies = bodies.length;


		double t = 0.0;
		while (t < T){
			double[] xForces = new double[numBodies];
			double[] yForces = new double[numBodies];

			// calc forces and update bodies
			for (int i = 0; i < numBodies; ++i){
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);

				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			// draw background
			StdDraw.picture(0, 0, "images/starfield.jpg", 2*univRad, 2*univRad);
			
			// draw bodies
			for (int i = 0; i < numBodies; ++i){
				bodies[i].draw();
			}

			// show the pic
			StdDraw.show();
			// pause for 10 msec
			StdDraw.pause(10);

			// increase the time
			t = t + dt;
		}

		// output the final stage
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", univRad);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            	      bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                	  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}

	}
}