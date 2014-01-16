
package objloader;

import java.io.IOException;

import javax.media.opengl.GLArrayData;

import simplerjogl.*;

public class JOGLRenderer extends Renderer
{
	private ObjReader suzanne;
	
	public void init ()
	{
		try {
			suzanne = new ObjReader("model/suzanne.obj");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display ()
	{
		glu.gluLookAt (0, 0, 5, 0, 0, 0, 0, 1, 0);
		gl.glVertexPointer((GLArrayData) suzanne.getVertices());
	}
}