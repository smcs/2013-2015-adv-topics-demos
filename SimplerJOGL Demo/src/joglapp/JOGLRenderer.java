
package joglapp;

import simplerjogl.*;

public class JOGLRenderer extends Renderer
{
	private double rot, x, y, z;
	private Light l;
	
	public void init ()
	{
		rot = 0;
		x = 1;
		y = 1;
		z = 1;
		l = new Light(gl);
		l.enable();
	}

	public void display ()
	{
		glu.gluLookAt (
				0, 0, 5,
				0, 0, 0,
				0, 1, 0
			);
		gl.glRotated(rot, x, y, z);
		gl.glTranslated(1, 0, 0);
		rot++;
		glut.glutSolidSphere(1, 4, 24);
	}
}